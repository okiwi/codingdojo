public class BizarrerieDeJaky {

    public boolean isInstagrammable(Mileage mileage) {

        if (mileage.isAscending()) return true;
        if (mileage.isJamesBond()) return true;
        if (mileage.isLicensedToKill()) return true;
        if (mileage.isJackyBirthDate()) return true;
        return false;
    }
}
