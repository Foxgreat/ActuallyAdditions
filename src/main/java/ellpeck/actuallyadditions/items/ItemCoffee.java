package ellpeck.actuallyadditions.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ellpeck.actuallyadditions.config.values.ConfigIntValues;
import ellpeck.actuallyadditions.items.metalists.TheMiscItems;
import ellpeck.actuallyadditions.util.INameableItem;
import ellpeck.actuallyadditions.util.ItemUtil;
import ellpeck.actuallyadditions.util.KeyUtil;
import ellpeck.actuallyadditions.util.ModUtil;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class ItemCoffee extends ItemFood implements INameableItem{

    public static ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public static void initIngredients(){
        registerIngredient(new Ingredient(new ItemStack(Items.milk_bucket), null, 0){
            @Override
            public boolean effect(ItemStack stack){
                PotionEffect[] effects = getEffectsFromStack(stack);
                ArrayList<PotionEffect> effectsNew = new ArrayList<PotionEffect>();
                if(effects != null && effects.length > 0){
                    for(PotionEffect effect : effects){
                        if(effect.getAmplifier() > 0) effectsNew.add(new PotionEffect(effect.getPotionID(), effect.getDuration()+120, effect.getAmplifier()-1));
                    }
                    stack.setTagCompound(new NBTTagCompound());
                    if(effectsNew.size() > 0){
                        this.effects = effectsNew.toArray(new PotionEffect[effectsNew.size()]);
                        ItemCoffee.addEffectToStack(stack, this);
                    }
                }
                this.effects = null;
                return true;
            }
            @Override
            public String getExtraText(){
                return StatCollector.translateToLocal("container.nei." + ModUtil.MOD_ID_LOWER + ".coffee.extra.milk");
            }
        });
        registerIngredient(new Ingredient(new ItemStack(Items.sugar), new PotionEffect[]{new PotionEffect(Potion.moveSpeed.getId(), 30, 0)}, 4));
        registerIngredient(new Ingredient(new ItemStack(Items.magma_cream), new PotionEffect[]{new PotionEffect(Potion.fireResistance.getId(), 20, 0)}, 1));
        registerIngredient(new Ingredient(new ItemStack(Items.fish, 1, 3), new PotionEffect[]{new PotionEffect(Potion.waterBreathing.getId(), 10, 0)}, 1));
        registerIngredient(new Ingredient(new ItemStack(Items.golden_carrot), new PotionEffect[]{new PotionEffect(Potion.nightVision.getId(), 30, 0)}, 1));
        registerIngredient(new Ingredient(new ItemStack(Items.ghast_tear), new PotionEffect[]{new PotionEffect(Potion.regeneration.getId(), 5, 0)}, 3));
        registerIngredient(new Ingredient(new ItemStack(Items.blaze_powder), new PotionEffect[]{new PotionEffect(Potion.damageBoost.getId(), 15, 0)}, 4));
        registerIngredient(new Ingredient(new ItemStack(Items.fermented_spider_eye), new PotionEffect[]{new PotionEffect(Potion.invisibility.getId(), 25, 0)}, 1));
    }

    public ItemCoffee(){
        super(8, 5.0F, false);
        this.setMaxDamage(ConfigIntValues.COFFEE_DRINK_AMOUNT.getValue()-1);
        this.setAlwaysEdible();
        this.setMaxStackSize(1);
        this.setNoRepair();
    }

    public static Ingredient getIngredientFromStack(ItemStack stack){
        for(Ingredient ingredient : ingredients){
            if(ingredient.ingredient.copy().isItemEqual(stack)) return ingredient;
        }
        return null;
    }

    public static void addEffectProperties(ItemStack stack, PotionEffect effect, boolean addDur, boolean addAmp){
        PotionEffect[] effects = getEffectsFromStack(stack);
        stack.setTagCompound(new NBTTagCompound());
        for(int i = 0; i < effects.length; i++){
            if(effects[i].getPotionID() == effect.getPotionID()){
                effects[i] = new PotionEffect(effects[i].getPotionID(), effects[i].getDuration()+(addDur ? effect.getDuration() : 0), effects[i].getAmplifier()+(addAmp ? (effect.getAmplifier() > 0 ? effect.getAmplifier() : 1) : 0));
            }
            addEffectToStack(stack, effects[i]);
        }
    }

    public static void addEffectToStack(ItemStack stack, PotionEffect effect){
        NBTTagCompound tag = stack.getTagCompound();
        if(tag == null) tag = new NBTTagCompound();

        int prevCounter = tag.getInteger("Counter");
        NBTTagCompound compound = new NBTTagCompound();
        compound.setInteger("ID", effect.getPotionID());
        compound.setInteger("Duration", effect.getDuration());
        compound.setInteger("Amplifier", effect.getAmplifier());

        int counter = prevCounter+1;
        tag.setTag(counter+"", compound);
        tag.setInteger("Counter", counter);

        stack.setTagCompound(tag);
    }

    public static boolean addEffectToStack(ItemStack stack, Ingredient ingredient){
        boolean worked = false;
        if(ingredient != null){
            PotionEffect[] effects = ingredient.getEffects();
            if(effects != null && effects.length > 0){
                for(PotionEffect effect : effects){
                    PotionEffect effectHas = getSameEffectFromStack(stack, effect);
                    if(effectHas != null){
                        if(effectHas.getAmplifier() < ingredient.maxAmplifier-1){
                            addEffectProperties(stack, effect, false, true);
                            worked = true;
                        }
                    }
                    else{
                        addEffectToStack(stack, effect);
                        worked = true;
                    }
                }
            }
        }
        return worked;
    }

    public static PotionEffect[] getEffectsFromStack(ItemStack stack){
        ArrayList<PotionEffect> effects = new ArrayList<PotionEffect>();
        NBTTagCompound tag = stack.getTagCompound();
        if(tag != null){
            int counter = tag.getInteger("Counter");
            while(counter > 0){
                NBTTagCompound compound = (NBTTagCompound)tag.getTag(counter + "");
                PotionEffect effect = new PotionEffect(compound.getInteger("ID"), compound.getInteger("Duration"), compound.getByte("Amplifier"));
                if(effect.getPotionID() > 0){
                    effects.add(effect);
                }
                counter--;
            }
        }
        return effects.size() > 0 ? effects.toArray(new PotionEffect[effects.size()]) : null;
    }

    public static PotionEffect getSameEffectFromStack(ItemStack stack, PotionEffect effect){
        PotionEffect[] effectsStack = getEffectsFromStack(stack);
        if(effectsStack != null && effectsStack.length > 0){
            for(PotionEffect effectStack : effectsStack){
                if(effect.getPotionID() == effectStack.getPotionID()) return effectStack;
            }
        }
        return null;
    }

    public static void applyPotionEffectsFromStack(ItemStack stack, EntityPlayer player){
        PotionEffect[] effects = getEffectsFromStack(stack);
        if(effects != null && effects.length > 0){
            for(PotionEffect effect : effects){
                player.addPotionEffect(new PotionEffect(effect.getPotionID(), effect.getDuration()*20, effect.getAmplifier()));
            }
        }
    }

    @Override
    public boolean getShareTag(){
        return true;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack){
        return EnumAction.drink;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack){
        return EnumRarity.rare;
    }

    @Override
    public int getMetadata(int damage){
        return damage;
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player){
        ItemStack theStack = stack.copy();
        super.onEaten(stack, world, player);
        applyPotionEffectsFromStack(stack, player);
        theStack.setItemDamage(theStack.getItemDamage()+1);
        if(theStack.getMaxDamage()-theStack.getItemDamage() < 0) return new ItemStack(InitItems.itemMisc, 1, TheMiscItems.CUP.ordinal());
        else return theStack;
    }

    @Override
    @SuppressWarnings("unchecked")
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean isHeld){
        if(KeyUtil.isShiftPressed()){
            list.add(StatCollector.translateToLocal("tooltip."+ModUtil.MOD_ID_LOWER+"."+this.getName()+".desc.1"));
            list.add(StatCollector.translateToLocalFormatted("tooltip."+ModUtil.MOD_ID_LOWER+"."+this.getName()+".desc.2", this.getMaxDamage()+1));
            list.add(StatCollector.translateToLocal("tooltip."+ModUtil.MOD_ID_LOWER+".hunger.desc")+": "+this.func_150905_g(stack));
            list.add(StatCollector.translateToLocal("tooltip."+ModUtil.MOD_ID_LOWER+".saturation.desc")+": "+this.func_150906_h(stack));
            list.add("");

            PotionEffect[] effects = getEffectsFromStack(stack);
            if(effects != null && effects.length > 0){
                for(PotionEffect effect : effects){
                    list.add(StatCollector.translateToLocal(effect.getEffectName())+" "+(effect.getAmplifier()+1)+ " (" + Potion.getDurationString(new PotionEffect(0, effect.getDuration()*20, 0)) + ")");
                }
            }
            else list.add("No Effects");
        }
        else list.add(ItemUtil.shiftForInfo());
    }

    @Override
    public IIcon getIconFromDamage(int par1){
        return this.itemIcon;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconReg){
        itemIcon = iconReg.registerIcon(ModUtil.MOD_ID_LOWER + ":" + this.getName());
    }

    @Override
    public String getName(){
        return "itemCoffee";
    }

    public static void registerIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
    }

    public static class Ingredient{

        public final ItemStack ingredient;
        protected PotionEffect[] effects;
        public final int maxAmplifier;

        public Ingredient(ItemStack ingredient, PotionEffect[] effects, int maxAmplifier){
            this.ingredient = ingredient.copy();
            this.effects = effects;
            this.maxAmplifier = maxAmplifier;
        }

        public String getExtraText(){
            return null;
        }

        public PotionEffect[] getEffects(){
            return this.effects;
        }

        public boolean effect(ItemStack stack){
            return ItemCoffee.addEffectToStack(stack, this);
        }
    }
}