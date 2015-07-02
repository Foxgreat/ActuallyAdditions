package ellpeck.actuallyadditions.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ellpeck.actuallyadditions.blocks.metalists.TheWildPlants;
import ellpeck.actuallyadditions.util.BlockUtil;
import ellpeck.actuallyadditions.util.INameableItem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.ArrayList;
import java.util.List;

public class BlockWildPlant extends BlockBush implements INameableItem{

    public static final TheWildPlants[] allWildPlants = TheWildPlants.values();
    public IIcon[] textures = new IIcon[allWildPlants.length];

    public BlockWildPlant(){
        this.setStepSound(soundTypeGrass);
    }

    @Override
    public boolean canBlockStay(World world, int x, int y, int z){
        return world.getBlockMetadata(x, y, z) == TheWildPlants.RICE.ordinal() ? world.getBlock(x, y-1, z).getMaterial() == Material.water : world.getBlock(x, y - 1, z).canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, this);
    }

    @Override
    public boolean canSilkHarvest(){
        return false;
    }

    @SuppressWarnings("all")
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item item, CreativeTabs tab, List list){
        for (int j = 0; j < allWildPlants.length; j++){
            list.add(new ItemStack(item, 1, j));
        }
    }

    @Override
    public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune){
        return metadata >= allWildPlants.length ? null : allWildPlants[metadata].wildVersionOf.getDrops(world, x, y, z, 7, fortune);
    }

    @Override
    public IIcon getIcon(int side, int metadata){
        return metadata >= allWildPlants.length ? null : allWildPlants[metadata].wildVersionOf.getIcon(0, 7);
    }

    @Override
    public String getName(){
        return "blockWild";
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z){
        int meta = world.getBlockMetadata(x, y, z);
        return meta >= allWildPlants.length ? null : ((BlockPlant)allWildPlants[meta].wildVersionOf).seedItem;
    }

    public static class TheItemBlock extends ItemBlock{

        private Block theBlock;

        public TheItemBlock(Block block){
            super(block);
            this.theBlock = block;
            this.setHasSubtypes(true);
            this.setMaxDamage(0);
        }

        @Override
        public EnumRarity getRarity(ItemStack stack){
            return stack.getItemDamage() >= allWildPlants.length ? EnumRarity.common : allWildPlants[stack.getItemDamage()].rarity;
        }

        @Override
        public String getUnlocalizedName(ItemStack stack){
            return this.getUnlocalizedName() + (stack.getItemDamage() >= allWildPlants.length ? " ERROR!" : allWildPlants[stack.getItemDamage()].getName());
        }

        @Override
        @SuppressWarnings("unchecked")
        @SideOnly(Side.CLIENT)
        public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld) {
            if(stack.getItemDamage() < allWildPlants.length) BlockUtil.addInformation(theBlock, list, 1, allWildPlants[stack.getItemDamage()].getName());
        }

        @Override
        public int getMetadata(int damage){
            return damage;
        }

        @SideOnly(Side.CLIENT)
        @Override
        public IIcon getIconFromDamage(int meta){
            return this.theBlock.getIcon(0, meta);
        }

    }
}
