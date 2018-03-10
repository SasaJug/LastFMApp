package com.sasaj.lastfmapp.di;

import com.sasaj.lastfmapp.domain.Repository;
import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by sjugurdzija on 2/27/2018.
 */

@Singleton
@Component(modules = {HttpModule.class})
public interface HttpComponent {
    void inject(Repository repository);
}
