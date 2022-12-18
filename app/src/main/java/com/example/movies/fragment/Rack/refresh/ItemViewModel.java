package com.example.movies.fragment.Rack.refresh;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.movies.model.Movie;

public class ItemViewModel extends ViewModel {

    //creating livedata for PagedList  and PagedKeyedDataSource
  public   LiveData<PagedList<Movie>> itemPagedList;
    public  LiveData<PageKeyedDataSource<Integer, Movie>> liveDataSource;

    public ItemDataSourceFactory itemDataSourceFactory;

    //constructor
    public ItemViewModel() {
        //getting our data source factory
         itemDataSourceFactory = new ItemDataSourceFactory();


        //getting the live data source from data source factory
        liveDataSource = itemDataSourceFactory.getItemLiveDataSource();

        //Getting PagedList config
        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setPageSize(ItemDataSource.PAGE_SIZE).build();


        //Building the paged list
        itemPagedList = (new LivePagedListBuilder(itemDataSourceFactory, pagedListConfig)).build();

    }



    }
//    public void loadMoreData(){
//        if(!cancelLoading);
//            getRankingMovies(++pageNum);
//    }
