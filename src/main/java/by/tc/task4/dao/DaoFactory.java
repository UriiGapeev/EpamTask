package by.tc.task4.dao;
import by.tc.task4.dao.impl.ApplianceDAOImpl;
public final class DaoFactory {
    private static final DaoFactory instance = new DaoFactory();

    private final ApplianceDAO applianceDAO = new ApplianceDAOImpl();

    private DaoFactory() {}

    public ApplianceDAO getApplianceDAO() {
        return applianceDAO;
    }

    public static DaoFactory getInstance() {
        return instance;
    }
}
