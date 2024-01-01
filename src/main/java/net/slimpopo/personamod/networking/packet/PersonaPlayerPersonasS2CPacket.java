package net.slimpopo.personamod.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import net.slimpopo.personamod.client.ClientPersonaPlayerPersonaData;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class PersonaPlayerPersonasS2CPacket {
    private final int personaIdx;
    private final int personaLvl;
    private final int currentXp;
    private final int neededXp;

    private final int str;
    private final int mag;
    private final int agi;
    private final int end;
    private final int luc;

    private final int skillSize;
    private final String[] skills;

    public PersonaPlayerPersonasS2CPacket(int personaIdx, int personaLvl, int currentXp, int neededXp,
        int str, int mag, int agi, int end, int luc, String[] skills, int skillSize){
        this.personaIdx = personaIdx;
        this.personaLvl = personaLvl;
        this.currentXp  = currentXp;
        this.neededXp   = neededXp;

        this.str = str;
        this.mag = mag;
        this.end = end;
        this.agi = agi;
        this.luc = luc;

        this.skills = skills;
        this.skillSize = skillSize;

    }

    public PersonaPlayerPersonasS2CPacket(FriendlyByteBuf buf){
        this.personaIdx = buf.readInt();
        this.personaLvl = buf.readInt();
        this.currentXp = buf.readInt();
        this.neededXp = buf.readInt();

        this.str = buf.readInt();
        this.mag = buf.readInt();
        this.end = buf.readInt();
        this.agi = buf.readInt();
        this.luc = buf.readInt();
        this.skillSize = buf.readInt();

        List<String> skillList = new ArrayList<>();
        for(int i = 0; i < this.skillSize; i++)
            skillList.add(buf.readUtf());

        this.skills = skillList.toArray(new String[skillSize]);
    }

    public void toBytes(FriendlyByteBuf buf){
        buf.writeInt(personaIdx);
        buf.writeInt(personaLvl);
        buf.writeInt(currentXp);
        buf.writeInt(neededXp);

        buf.writeInt(str);
        buf.writeInt(mag);
        buf.writeInt(agi);
        buf.writeInt(end);
        buf.writeInt(luc);
        buf.writeInt(skills.length);

        for(int i = 0; i < skills.length;i++)
            buf.writeUtf(skills[i]);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier){
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientPersonaPlayerPersonaData.set(personaIdx,personaLvl,currentXp,neededXp,
                    str,mag,end,agi,luc,skills);
        });
        return true;
    }

}
