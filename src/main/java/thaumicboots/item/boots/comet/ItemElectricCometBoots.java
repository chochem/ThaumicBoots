package thaumicboots.item.boots.comet;

import net.minecraft.item.EnumRarity;
import net.minecraftforge.common.ISpecialArmor;

import ic2.api.item.IElectricItem;
import thaumicboots.api.ItemElectricBoots;
import thaumicboots.main.utils.TabThaumicBoots;

public class ItemElectricCometBoots extends ItemElectricBoots implements IElectricItem, ISpecialArmor {

    public float minimumHeight;
    public double minimumDistance;

    public ItemElectricCometBoots(ArmorMaterial par2EnumArmorMaterial, int par3, int par4) {
        super(par2EnumArmorMaterial, par3, par4);
        setCreativeTab(TabThaumicBoots.tabThaumicBoots);
        setUnlocalizedName(unlocalisedName);
    }

    protected void setBootsData() {
        maxCharge = 100_000;
        energyPerDamage = 1_000;
        runicCharge = 0;
        visDiscount = 2;
        provideEnergy = false;
        damageAbsorptionRatio = 1.5D;
        transferLimit = 100;
        jumpBonus = 0.275D;
        runningbonus = 0.003F;
        minimumHeight = 4F;
        minimumDistance = 20d;
        tier = 2;
        iconResPath = "thaumicboots:electricComet_16x";
        armorResPath = "thaumicboots:model/electricbootsComet.png";
        unlocalisedName = "ItemElectricComet";
        rarity = EnumRarity.rare;
    }

    public float getPowerConsumptionMultiplier(float distance) {
        return (distance > minimumDistance) ? distance * 3 : distance;
    }

    public float getPowerConsumption(float distance) {
        return energyPerDamage * (getPowerConsumptionMultiplier(distance) - getMinimumHeight());
    }

    public float getMinimumHeight() {
        return minimumHeight;
    }
}
