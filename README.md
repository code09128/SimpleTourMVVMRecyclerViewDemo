# SimpleTourMVVMRecyclerViewDemo
Simple Tour App Demo use mvvm architecture 

## OpenAPI 
https://www.travel.taipei/open-api/swagger/ui/index#/Attractions/Attractions_All

## Gradle
```gradle
    // cardview
    implementation 'androidx.cardview:cardview:1.0.0'

    // retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-gson:2.6.0'
    implementation 'com.squareup.retrofit2:converter-scalars:2.6.0'
    implementation 'com.squareup.okhttp3:logging-interceptor:3.11.0'

    // coroutine
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.1'
    implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1'

    //Glide
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'

    //Gson
    implementation 'com.google.code.gson:gson:2.8.5'
```

## App class package architecture
Custom
- showdata
  - View
    - adapter
      - TourDataAdapter
    - TourMainActivity
    - TourDetailFragment
    - WebViewFragment
  - ViewModel
    - TourDataViewModel
  - Model
    - TourDataModel
  - Repostory
    - TourDataRepository
    - ApiInterface

Util
- base
  - BaseFragment
  - BaseRecyclerAdapter
- global
  - BaseGlobalFunction
  - GlobalConfig
    
RetrofitHelp
