package org.afrinnov.rnd.afrinnovdgs.context;

import com.netflix.graphql.dgs.context.DgsCustomContextBuilder;
import org.afrinnov.rnd.afrinnovdgs.shared.context.MyContext;
import org.springframework.stereotype.Component;

@Component
public class MyContextBuilder implements DgsCustomContextBuilder<MyContext> {
    @Override
    public MyContext build() {
        return new MyContext();
    }
}
