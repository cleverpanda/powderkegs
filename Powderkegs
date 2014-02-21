package cleverpanda.powderkegs;

import cleverpanda.powderkegs.client.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler; 
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.RecipesCrafting;

@Mod(modid="Powderkegs", name="Powderkegs", version="0.1.85")
@NetworkMod(clientSideRequired=true, serverSideRequired=false, 
channels={"Powderkegs"}, packetHandler = PacketHandler.class)
public class Powderkegs {

		public static Block Powderkeg;
		
        // The instance that Forge uses.
        @Instance(value = "Powderkegs")
        public static Powderkegs instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="cleverpanda.powderkegs.client.ClientProxy", serverSide="cleverpanda.powderkegs.CommonProxy")
        public static CommonProxy proxy;
        
        @EventHandler // used only in 1.6.2
        public void preInit(FMLPreInitializationEvent event) {
        	Powderkeg = new PowderkegsBlock(714, net.minecraft.block.material.Material.wood).setHardness(2.0F)
        			.setStepSound(Block.soundWoodFootstep)
        			.setUnlocalizedName("PowderKeg")
        			.setCreativeTab(CreativeTabs.tabDecorations)
        			.setTextureName("powderkegs:PowderKeg");
        	LanguageRegistry.addName(Powderkeg, "Powder Keg");
        }
        
        @EventHandler // used only in 1.6.2
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                //proxy.registerRenderThings();
                GameRegistry.registerTileEntity(PowderkegsEntity.class, "Powder Keg");
                GameRegistry.registerBlock(Powderkeg, "Powder Keg");

                ItemStack wood = new ItemStack(Block.planks);
                GameRegistry.addRecipe(new ItemStack(Powderkeg), "w w","w w","www", 'w', wood);
        }
        
        @EventHandler // used in 1.6.2
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}
