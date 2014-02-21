package cleverpanda.powderkegs;

import org.lwjgl.input.Keyboard;

import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

// Version 0.2.14  
// 2/20/2014

public class PowderkegsEntity extends TileEntity {
	
	public int ItemAmount = 0; //Number of items in the keg
	public int ItemID = 0; //The item in the keg

	
	@Override
	   public void writeToNBT(NBTTagCompound nbt)
	   {
	      super.writeToNBT(nbt);
	      nbt.setInteger("ItemAmount", ItemAmount);
	      nbt.setInteger("ItemID", ItemID);

	   }

	   @Override
	   public void readFromNBT(NBTTagCompound nbt)
	   {
	      super.readFromNBT(nbt);
	      this.ItemAmount = nbt.getInteger("ItemAmount");
	      this.ItemID = nbt.getInteger("ItemID");

	   }
	     
	   public static void spawnItem (World world, double x, double y, double z, ItemStack item){
			if (item != null && !world.isRemote) {
				int stackSize = (int) Math.ceil(item.stackSize / item.getMaxStackSize());
				int stacksToSpawn = (stackSize < 64) ? stackSize : 64;
				int itemsPerStack = (stackSize == 0) ? 0 : (int) (Math.ceil(item.stackSize / stacksToSpawn));
				int excess = (stackSize == 0) ? item.stackSize : item.stackSize % stacksToSpawn;
				
				item.stackSize = itemsPerStack;
				for (int spawn = 0; spawn < stacksToSpawn; spawn++){
					EntityItem entity = new EntityItem(world, x, y+.5, z, item.copy());
					entity.delayBeforeCanPickup = 20;
					
					world.spawnEntityInWorld(entity);
				}
				
				if (excess != 0){
					item.stackSize = excess;
					
					EntityItem entity = new EntityItem(world, x, y+.5, z, item.copy());
					entity.delayBeforeCanPickup = 20;
					
					world.spawnEntityInWorld(entity);
				}
			}
		}
	   
	   public void RightClick(EntityPlayer player, World world, int x,int y,int z) {
		   
		   PowderkegsEntity keg = (PowderkegsEntity)world.getBlockTileEntity(x, y, z);
	        ItemStack itemstack = player.inventory.getCurrentItem();
	        
	        if(itemstack != null && (itemstack.getItem().itemID == 289 || itemstack.getItem().itemID == 295 || itemstack.getItem().itemID == 331
	        		|| itemstack.getItem().itemID == 353 ||itemstack.getItem().itemID == 377 ||itemstack.getItem().itemID == 348))	
	        {
	        	player.addChatMessage("clicked with "+ itemstack.getItem().getStatName());
	        	
	        	if (keg != null && keg.ItemID == 0){
	        		keg.ItemID = itemstack.getItem().itemID;

	        	}
	        	
	        	if (keg != null && itemstack.getItem().itemID == keg.ItemID)
	        	{
	        		keg.ItemAmount = keg.ItemAmount + itemstack.stackSize;
	        		player.addChatMessage("Clicked with correct item");
	        		
	        		if(itemstack.stackSize > 0 ){
	        			player.addChatMessage("stack bigger than 0");
	        			//ItemStack newstack = new ItemStack(itemstack.getItem(), itemstack.stackSize - 1);    //itemstack.stackSize - 1;
	        			player.inventory.setInventorySlotContents(player.inventory.currentItem,(ItemStack)null);
	        		}
	        		//ItemStack NewItemStack = Player.inventory.decrStackSize(int par1,int par2);
	        		//Player.inventory.decrStackSize(Player.inventory.currentItem, newsize);
	        	}
	        }
	        world.notifyBlockChange(xCoord, yCoord, zCoord, 2);
	}
	   
	   public void LeftClick(EntityPlayer player, World world, int x,int y,int z){
		   PowderkegsEntity keg = (PowderkegsEntity)world.getBlockTileEntity(x, y, z);
		   player.addChatMessage("this keg has " +ItemAmount +" of item "+ keg.ItemID);
		   
		   if(!(Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) ){
			   if(keg.ItemAmount > 64){
	        		ItemStack itemtype = new ItemStack(keg.ItemID, 64, 0);
		        	 spawnItem(world, x, y, z, itemtype);
		        	 keg.ItemAmount = keg.ItemAmount - 64;
	        	}
	        	else{
	        		if(!(keg.ItemAmount == 0)){
	        			ItemStack itemtype = new ItemStack(keg.ItemID, keg.ItemAmount, 0);
		        		spawnItem(world, x, y, z, itemtype);
		        		keg.ItemAmount = 0;
		        		keg.ItemID = 0;
	        		}
	        		
	        	}
       		
		   }
		   if(Keyboard.isKeyDown(Keyboard.KEY_RSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)){
			   
	        	if(keg.ItemAmount >= 1){
	        		ItemStack itemtype = new ItemStack(keg.ItemID, 1, 0);
		        	 spawnItem(world, x, y, z, itemtype);
		        	 keg.ItemAmount --;
	        	}
	        	
	        }
	   }
}
