package com.sasaj.lastfmapp.domain;

import com.sasaj.lastfmapp.repository.LastFmRepository;
import com.sasaj.lastfmapp.repository.local.database.LocalStorage;
import com.sasaj.lastfmapp.repository.remote.httpclient.HttpClient;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import static junit.framework.Assert.assertTrue;
import static org.mockito.Mockito.*;


/**
 * Created by sjugurdzija on 3/5/2018.
 */
public class LastFmRepositoryTest {

    private Chart testChart = new Chart();

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private
    HttpClient httpClient;

    @Mock
    private LocalStorage localStorage;

    private LastFmRepository lastFmRepository;
    private List<Artist> artistsList;

    @Before
    public void setUp(){
        lastFmRepository = new LastFmRepository(httpClient, localStorage);
        Artists artists = new Artists();
        Artist artist = new Artist("Sasa", "", "", "", "", "", null);
        artistsList = new ArrayList<>();
        artistsList.add(artist);
        artists.setArtist(artistsList);
        testChart.setArtists(artists);
    }

    @After
    public void tearDown() {
        lastFmRepository = null;
    }

    @Test
    public void getArtists(){
        when(localStorage.getArtists()).thenReturn(Flowable.just(artistsList));
        Flowable<List<Artist>> result = lastFmRepository.getArtists();
        assertTrue (result.blockingFirst().get(0).getName().equals("Sasa"));
    }

    @Test
    public void refreshArtists(){
    }

    @Test
    public void getArtist(){
    }

    @Test
    public void getImages(){
    }

}