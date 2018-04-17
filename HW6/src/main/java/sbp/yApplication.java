package sbp;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class yApplication extends Application<yConfiguration> {

    public static void main(final String[] args) throws Exception {
        new yApplication().run(args);
    }

    @Override
    public String getName() {
        return "y";
    }

    @Override
    public void initialize(final Bootstrap<yConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final yConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
