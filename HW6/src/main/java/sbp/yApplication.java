package sbp;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import sbp.api.Sneaker;
import sbp.db.SneakerDAO;
import sbp.health.DBHealthCheck;
import sbp.resources.SneakerResource;

public class yApplication extends Application<yConfiguration> {

    public static void main(final String[] args) throws Exception {
        new yApplication().run(args);
    }

    @Override
    public String getName() {
        return "y";
    }

    private final HibernateBundle<yConfiguration> hibernate = new HibernateBundle<yConfiguration>(Sneaker.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(yConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(final Bootstrap<yConfiguration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }

    @Override
    public void run(final yConfiguration configuration,
            final Environment environment) {
    final SneakerDAO dao = new SneakerDAO(hibernate.getSessionFactory());
    environment.jersey().register(new SneakerResource(dao));
    }

}
