# SimpleTourMVVMRecyclerViewDemo
Simple Tour App Demo use mvvm architecture 

# OpenAPI 
https://www.travel.taipei/open-api/swagger/ui/index#/Attractions/Attractions_All

# Gradle
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

# App class package architecture
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

# Show UI
## show loading data
<div  align="center">
<img src="https://github.com/code09128/SimpleTourMVVMRecyclerViewDemo/assets/32324308/13ca77a8-70b9-4525-8e93-def6f6038ddf" width="350px"/>
</div>

## select language
<div  align="center">
<img src="https://github.com/code09128/SimpleTourMVVMRecyclerViewDemo/assets/32324308/70ea2eaf-1a68-4e78-9100-6fdf1f840643" width="350px"/>
</div>

## Display user change language
<div  align="center">
<img src="https://github.com/code09128/SimpleTourMVVMRecyclerViewDemo/assets/32324308/c271471a-8ee8-45f2-8919-2498599d6cbd" width="350px"/>
</div>

## Detail Tour information & WebView info
<div  align="center">
<img src="https://github.com/code09128/SimpleTourMVVMRecyclerViewDemo/assets/32324308/04aac19d-578b-43ea-8a28-f6bbd950b2e3" width="350px"/>
</div>

