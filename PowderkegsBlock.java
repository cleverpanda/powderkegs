package cleverpanda.powderkegs;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

//Version 0.4.51

public class PowderkegsBlock extends BlockContainer{
	
	public PowderkegsBlock (int id, Material material) 
    {
            super(id, material);
            this.setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
    }
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer Player, int par7, float par8, float par9, float par10)
    {
		if (!world.isRemote)
		{
		PowderkegsEntity t = (PowderkegsEntity) world.getBlockTileEntity(x, y, z); //changed to tileentity
                    t.RightClick(Player, world, x, y, z);

		return true;
		}
		return false; 
    }
	
	@Override
	public void onBlockClicked(World world, int x, int y, int z, EntityPlayer Player)
    {
		if (!world.isRemote)
		{
		PowderkegsEntity t = (PowderkegsEntity) world.getBlockTileEntity(x, y, z); //changed to tileentity
                    t.LeftClick(Player, world, x, y, z);
		}
    }
	
	
	
    public boolean hasTileEntity(int metadata)
    {
        return true;
    }
    
	//Make sure set this as TileEntity class relevant for the block!
    @Override
    public TileEntity createNewTileEntity(World world) { // , int metadata)
        try{    
        	return new PowderkegsEntity();
        }
        catch (Exception var3){
        	throw new RuntimeException(var3);
        }
    }
    
    //I don't want the normal render type, because it wont render properly.
    @Override
    public int getRenderType() {
            return -1;
    }
    
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    public boolean renderAsNormalBlock() {
            return false;
    }
    
    //Icon to use for showing the block in your hand.
    public void registerIcons(IconRegister icon) {
            this.blockIcon = icon.registerIcon("Powderkegs:PowderKeg");
    }
    
    
    
}
