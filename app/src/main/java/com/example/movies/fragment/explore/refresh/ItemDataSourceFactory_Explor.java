package com.example.movies.fragment.explore.refresh;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.movies.model.Movie;

public class ItemDataSourceFactory_Explor extends DataSource.Factory {

    //creating the mutable live data
    private MutableLiveData<PageKeyedDataSource<Integer, Movie>> itemLiveDataSource =
            new MutableLiveData<>();
    public   ItemDataSource_Explor itemDataSource;
    @Override
    public DataSource<Integer, Movie> create() {
        //getting our data source object
        itemDataSource = new ItemDataSource_Explor();

        //posting the datasource to get the values
        itemLiveDataSource.postValue(itemDataSource);

        //returning the datasource
        return itemDataSource;
    }


    //getter for itemlivedatasource
    public MutableLiveData<PageKeyedDataSource<Integer, Movie>> getItemLiveDataSource() {
        return itemLiveDataSource;
    }

}