/*
 * This file ("SmileyCloudEasterEggs.java") is part of the Actually Additions mod for Minecraft.
 * It is created and owned by Ellpeck and distributed
 * under the Actually Additions License to be found at
 * http://ellpeck.de/actaddlicense
 * View the source code at https://github.com/Ellpeck/ActuallyAdditions
 *
 * © 2015-2016 Ellpeck
 */

package de.ellpeck.actuallyadditions.mod.misc.cloud;

import de.ellpeck.actuallyadditions.mod.blocks.InitBlocks;
import de.ellpeck.actuallyadditions.mod.items.InitItems;
import de.ellpeck.actuallyadditions.mod.items.metalists.TheFoods;
import de.ellpeck.actuallyadditions.mod.items.metalists.TheMiscItems;
import de.ellpeck.actuallyadditions.mod.util.AssetUtil;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class SmileyCloudEasterEggs{

    public static List<ISmileyCloudEasterEgg> cloudStuff = new ArrayList<ISmileyCloudEasterEgg>();

    static{
        //Glenthor
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"glenthor", "glenthorlp", "twoofeight"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(true, new ItemStack(Items.DYE, 1, 2));
                renderHeadBlock(InitBlocks.blockHeatCollector, 0, 5F);
            }
        });
        //Ellpeck
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"ellpeck", "ellopecko", "peck"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(InitItems.itemPhantomConnector));
                renderHeadBlock(InitBlocks.blockPhantomLiquiface, 0, 25F);
            }
        });
        //Tyrex
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"tyrex", "lord_tobinho", "tobinho"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.FISHING_ROD));
                renderHoldingItem(true, new ItemStack(Items.FISH));
            }
        });
        //Hose
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"dqmhose", "xdqmhose", "hose"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.REEDS));
                renderHeadBlock(Blocks.TORCH, 0, 15F);
            }
        });
        //Tobi
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"jemx", "jemxx", "jemxxx", "spielertobi200"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(true, new ItemStack(Items.MILK_BUCKET));
                renderHeadBlock(Blocks.LIT_REDSTONE_LAMP, 0, 35F);
            }
        });
        //Vazkii
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"vazkii", "vaski", "waskie"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(true, new ItemStack(Items.DYE, 1, 15));
                renderHeadBlock(Blocks.RED_FLOWER, 5, 20F);
            }
        });
        //Kitty
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"kitty", "kiddy", "kittyvancat", "kittyvancatlp"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(true, new ItemStack(Items.FISH));
                renderHoldingItem(false, new ItemStack(Items.MILK_BUCKET));
                renderHeadBlock(Blocks.WOOL, 10, 15F);
            }
        });
        //Canitzp
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"canitz", "canitzp", "kannnichts", "kannnichtsp"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.WOODEN_SWORD));
                renderHeadBlock(Blocks.CHEST, 0, 70F);
            }
        });
        //Lari
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"lari", "larixine", "xine", "laxi", "lachsirine", "lala", "lalilu"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.IRON_HELMET));
                renderHeadBlock(InitBlocks.blockBlackLotus, 0, 28F);
            }
        });
        //RotesDing
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"rotesding", "dotesring"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.MILK_BUCKET));
                renderHoldingItem(true, new ItemStack(Items.DYE, 1, 1));
                renderHeadBlock(Blocks.WOOL, 14, 18F);
            }
        });
        //Bande
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"bande", "bandelenth"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.DIAMOND_PICKAXE));
                renderHeadBlock(Blocks.WOOL, 4, 18F);
            }
        });
        //Wolle
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"wolle", "wuitoi"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.STRING));
                renderHeadBlock(Blocks.WOOL, 0, 18F);
            }
        });
        //Pakto
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"pakto", "paktosan", "paktosanlp"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.DYE, 1, 9));
                renderHeadBlock(InitBlocks.blockColoredLampOn, 6, 18F);
            }
        });
        //Honka
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"honka", "honkalonka", "lonka", "lonki"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(InitItems.itemLeafBlowerAdvanced, 1, 9));
                renderHeadBlock(Blocks.HAY_BLOCK, 0, 74F);
            }
        });
        //Acid
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"acid", "acid_blues", "acidblues"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(InitItems.itemFoods, 1, TheFoods.PIZZA.ordinal()));
                renderHeadBlock(Blocks.BOOKSHELF, 0, 27F);
            }
        });
        //Jasin
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"jasin", "jasindow"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.WRITTEN_BOOK));
                renderHeadBlock(Blocks.WEB, 0, 56F);
            }
        });
        //ShadowNinjaCat
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"shadowninjacat", "ninja", "tl"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.DIAMOND_SWORD));
                renderHeadBlock(Blocks.DIAMOND_BLOCK, 0, 26F);
            }
        });
        //NihonTiger
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"nihon", "nihontiger", "tiger"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.STONE_PICKAXE));
                renderHoldingItem(true, new ItemStack(Items.POISONOUS_POTATO));
                renderHeadBlock(Blocks.GRAVEL, 0, 47F);
            }
        });
        //FrauBaerchen
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"fraubaerchen", "baerchen", "nina"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.COOKIE));
                renderHoldingItem(true, new ItemStack(Items.PAPER));
                renderHeadBlock(Blocks.COAL_BLOCK, 0, 60F);
            }
        });
        //Diddi
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"0xdd", "didi", "diddi", "theultimatehose"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(true, new ItemStack(InitItems.itemDrill));
                renderHeadBlock(Blocks.REDSTONE_BLOCK, 0, 30F);
            }
        });
        //MineLoad
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"mineload", "miney", "loady", "mineyloady"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(InitItems.itemMagnetRing));
                renderHeadBlock(Blocks.CRAFTING_TABLE, 0, 35F);
            }
        });
        //Kilobyte (When I asked him if he liked the mod, he just looked at the code. Maybe he'll find this eventually.)
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"kilobyte", "kilo", "byte"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(InitItems.itemMisc, 1, TheMiscItems.DRILL_CORE.ordinal()));
                renderHeadBlock(Blocks.REDSTONE_ORE, 0, 80F);
            }
        });
        //XDjackieXD
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"jackie", "xdjackiexd", "xdjackie", "jackiexd"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.ENCHANTED_BOOK));
                renderHeadBlock(InitBlocks.blockDirectionalBreaker, 0, 40F);
            }
        });
        //Little Lampi (I still can't get over it)
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"lampi", "littlelampi", "little lampi"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.GLOWSTONE_DUST));
                renderHeadBlock(InitBlocks.blockColoredLampOn, 4, 40F);
            }
        });
        //AtomSponge
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"sponge", "atomsponge", "atom", "explosions", "explosion"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(Items.GUNPOWDER));
                renderHeadBlock(Blocks.SPONGE, 0, 20F);
            }
        });
        //Mattzimann
        register(new ISmileyCloudEasterEgg(){
            @Override
            public String[] getTriggerNames(){
                return new String[]{"mattzimann", "mattziman", "matziman", "marzipan", "mattzi"};
            }

            @Override
            public void renderExtra(float f){
                renderHoldingItem(false, new ItemStack(InitItems.itemSwordEmerald));
                renderHeadBlock(InitBlocks.blockCoffeeMachine, 0, 35F);
            }
        });
    }

    private static void register(ISmileyCloudEasterEgg egg){
        cloudStuff.add(egg);
    }

    private static void renderHoldingItem(boolean leftHand, ItemStack stack){
        GlStateManager.pushMatrix();
        GlStateManager.rotate(180F, 0F, 0F, 1F);
        GlStateManager.rotate(90, 0, 1, 0);
        GlStateManager.translate(0.2, -1F, leftHand ? -0.525F : 0.525F);
        GlStateManager.scale(0.75F, 0.75F, 0.75F);

        AssetUtil.renderItemInWorld(stack);

        GlStateManager.popMatrix();
    }

    private static void renderHeadBlock(Block block, int meta, float rotation){
        GlStateManager.pushMatrix();
        GlStateManager.disableLighting();
        GlStateManager.translate(-0.015F, 0.625F, 0.04F);
        GlStateManager.scale(0.5F, 0.5F, 0.5F);
        GlStateManager.rotate(180F, 1F, 0F, 0F);
        GlStateManager.rotate(rotation, 0F, 1F, 0F);

        AssetUtil.renderBlockInWorld(block, meta);

        GlStateManager.enableLighting();
        GlStateManager.popMatrix();
    }
}
