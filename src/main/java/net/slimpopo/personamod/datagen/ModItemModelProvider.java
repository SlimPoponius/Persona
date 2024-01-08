package net.slimpopo.personamod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.slimpopo.personamod.PersonaMod;
import net.slimpopo.personamod.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, PersonaMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.AGI);
        simpleItemWithCustomTag(ModItems.AGILAO, ModItems.AGI.getId().getPath());
        simpleItemWithCustomTag(ModItems.AGIDYNE, ModItems.AGI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MARAGI, ModItems.AGI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MARAGION, ModItems.AGI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MARAGIDYNE, ModItems.AGI.getId().getPath());
        simpleItemWithCustomTag(ModItems.FLAMETHROWABLE, ModItems.AGI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAFLAMETHROWABLE, ModItems.AGI.getId().getPath());

        simpleItem(ModItems.BUFU);
        simpleItemWithCustomTag(ModItems.BUFULA, ModItems.BUFU.getId().getPath());
        simpleItemWithCustomTag(ModItems.BUFUDYNE, ModItems.BUFU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MABUFU, ModItems.BUFU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MABUFULA, ModItems.BUFU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MABUFUDYNE, ModItems.BUFU.getId().getPath());
        simpleItemWithCustomTag(ModItems.ICETHROWABLE, ModItems.BUFU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAICETHROWABLE, ModItems.BUFU.getId().getPath());

        simpleItem(ModItems.GARU);
        simpleItemWithCustomTag(ModItems.GARULA, ModItems.GARU.getId().getPath());
        simpleItemWithCustomTag(ModItems.GARUDYNE, ModItems.GARU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAGARU, ModItems.GARU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAGARULA, ModItems.GARU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAGARUDYNE, ModItems.GARU.getId().getPath());
        simpleItemWithCustomTag(ModItems.WINDTHROWABLE, ModItems.GARU.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAWINDTHROWABLE, ModItems.GARU.getId().getPath());

        simpleItem(ModItems.ZIO);
        simpleItemWithCustomTag(ModItems.ZIONGA, ModItems.ZIO.getId().getPath());
        simpleItemWithCustomTag(ModItems.ZIODYNE, ModItems.ZIO.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAZIO, ModItems.ZIO.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAZIONGA, ModItems.ZIO.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAZIODYNE, ModItems.ZIO.getId().getPath());
        simpleItemWithCustomTag(ModItems.ELECTRICTHROWABLE, ModItems.ZIO.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAELECTRICTHROWABLE, ModItems.ZIO.getId().getPath());

        simpleItem(ModItems.FREI);
        simpleItemWithCustomTag(ModItems.FREILA, ModItems.FREI.getId().getPath());
        simpleItemWithCustomTag(ModItems.FREIDYNE, ModItems.FREI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAFREI, ModItems.FREI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAFREILA, ModItems.FREI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAFREIDYNE, ModItems.FREI.getId().getPath());
        simpleItemWithCustomTag(ModItems.NUKETHROWABLE, ModItems.FREI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MANUKETHROWABLE, ModItems.FREI.getId().getPath());

        simpleItem(ModItems.PSI);
        simpleItemWithCustomTag(ModItems.PSIO, ModItems.PSI.getId().getPath());
        simpleItemWithCustomTag(ModItems.PSIODYNE, ModItems.PSI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAPSI, ModItems.PSI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAPSIO, ModItems.PSI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAPSIODYNE, ModItems.PSI.getId().getPath());
        simpleItemWithCustomTag(ModItems.PSITHROWABLE, ModItems.PSI.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAPSITHROWABLE, ModItems.PSI.getId().getPath());

        simpleItemWithCustomTag(ModItems.MUDO, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MUDOON, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAMUDO, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAMUDOON, ModItems.EIHA.getId().getPath());

        simpleItem(ModItems.EIHA);
        simpleItemWithCustomTag(ModItems.EIGA, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.EIGAON, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAEIHA, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAEIGA, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAEIGAON, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.CURSETHROWABLE, ModItems.EIHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MACURSETHROWABLE, ModItems.EIHA.getId().getPath());

        simpleItemWithCustomTag(ModItems.HAMA, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.HAMAON, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAHAMA, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAHAMAON, ModItems.KOUHA.getId().getPath());

        simpleItem(ModItems.KOUHA);
        simpleItemWithCustomTag(ModItems.KOUGA, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.KOUGAON, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAKOUHA, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAKOUGA, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MAKOUGAON, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.BLESSTHROWABLE, ModItems.KOUHA.getId().getPath());
        simpleItemWithCustomTag(ModItems.MABLESSTHROWABLE, ModItems.KOUHA.getId().getPath());

        simpleItem(ModItems.MEGIDO);
        simpleItemWithCustomTag(ModItems.MEGIDOLA, ModItems.MEGIDO.getId().getPath());
        simpleItemWithCustomTag(ModItems.MEGIDOLAON, ModItems.MEGIDO.getId().getPath());

        simpleItemWithCustomTag(ModItems.TARUKAJA, "support");
        simpleItemWithCustomTag(ModItems.MATARUKAJA, "support");
        simpleItemWithCustomTag(ModItems.RAKUKAJA, "support");
        simpleItemWithCustomTag(ModItems.MARAKUKAJA, "support");
        simpleItemWithCustomTag(ModItems.SUKUKAJA, "support");
        simpleItemWithCustomTag(ModItems.MASUKUKAJA, "support");
        simpleItemWithCustomTag(ModItems.HEATRISER, "support");
        simpleItemWithCustomTag(ModItems.DEKAJA, "support");
        simpleItemWithCustomTag(ModItems.CONCENTRATE, "support");
        simpleItemWithCustomTag(ModItems.CHARGE, "support");
        simpleItemWithCustomTag(ModItems.TARUNDA, "support");
        simpleItemWithCustomTag(ModItems.MATARUNDA, "support");
        simpleItemWithCustomTag(ModItems.RAKUNDA, "support");
        simpleItemWithCustomTag(ModItems.MARAKUNDA, "support");
        simpleItemWithCustomTag(ModItems.SUKUNDA, "support");
        simpleItemWithCustomTag(ModItems.MASUKUNDA, "support");
        simpleItemWithCustomTag(ModItems.DEKUNDA, "support");
        simpleItemWithCustomTag(ModItems.DEBILITATE, "support");
        simpleItemWithCustomTag(ModItems.TETRAJA, "support");


        simpleItemWithCustomTag(ModItems.SKILLCARD, "arcana");
        simpleItemWithCustomTag(ModItems.STATCARD, "arcana");
        simpleItemWithCustomTag(ModItems.PERSONACARD, "arcana");
        simpleItemWithCustomTag(ModItems.ARCANACARD, "arcana");

        withExistingParent(ModItems.PYRO_JACK_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
        withExistingParent(ModItems.PYRO_JACK_SUMMON_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));


    }

    private ItemModelBuilder simpleItem(RegistryObject<? extends Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PersonaMod.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleItemWithCustomTag(RegistryObject<? extends Item> item, String tag){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(PersonaMod.MOD_ID,"item/" + tag));
    }
}
