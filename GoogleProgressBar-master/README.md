GoogleProgressBar
===============

Android library to display different kind of google related animations for the progressBar.

Only this animation has been finished so far:

![FoldingCirclesProgressBar][1]

  FoldingCirclesProgressBar

TODO
----


 I would love to receive your pull requests to create any of the following animations or others that you think fit on this library:

 * [GOOGLE_MUSIC_DICES](https://raw.githubusercontent.com/jpardogo/GoogleProgressBar/dev/art/GoogleDices.gif)

   Dices I'm feeling lucky progress of google music app.

 * [NEXUS_CIRCLES](http://ikslawok.free.fr/my_nexus_fr/nexus_5/bootanimation_nexus_5.gif):

    Nexus 5 circles boot progress animation (Just the circles bouncing)

 * [NEXUS_CROSS](http://devfest.gdgthess.org/wp-content/uploads/2013/11/nexus-4-boot-animation.gif):

    Galaxy nexus shinny cross boot animation

 * [NEXUS_ROTATION_CROSS](http://deathlyspectator.files.wordpress.com/2012/03/sampleb.gif):

    Nexus one rotation cross animation (Just the cross rotation)

Usage
-----

######Dynamically
Add a ProgressBar to the xml layout:

```xml
     <ProgressBar
            android:id="@+id/google_progress"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_gravity="center"/>
```

Choose from the list of `Drawable`s the one you want to use and place it in your code:

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        mProgressBar.setIndeterminateDrawable(new your_list_option.Builder(this)
                    .build());
        //...
    }
```

`your_list_option` can be replace for:

* FoldingCirclesDrawable

The more custom `Drawable`s finished, the more options in this list.

**Attributes depending on the drawable:**

* FoldingCirclesDrawable

```java
    mProgressBar.setIndeterminateDrawable(new you_list_option.Builder(this)
                                                             .colors(getResources().getIntArray(R.array.colors) //Array of 4 colors
                                                             .build());
```
The animation speed can be modified easily with `android:indeterminateDuration` in the xml.

If not colors are define the 4 default google colors (red,blue, yellow and green) will be used.

######From XML

When you want to use the `GoogleProgresBar` from XML you need to add the following view to your layout:

```java
    <com.jpardogo.android.googleprogressbar.library.GoogleProgressBar
            android:id="@+id/google_progress"
            android:layout_width="50dp"
            android:layout_height="50dp"
            android:layout_gravity="center"
            gpb:type="your_list_option"/>
```
The require attribute `gpb:type` will specify the type of `ProgressBar` to display

`your_list_option` can be replace for:

* folding_circles

The more custom `Drawable`s finished, the more options in this list.

Each type of `GoogleProgressBar` have different attributes:

**Attributes depending on type:**

* folding_circles
    * `gpb:colors="@array/colors"`
        * Optional, If not colors are define the 4 default google colors (red,blue, yellow and green) will be used.
        * It needs to be an array of 4 colors

The animation speed can be modified easily with `android:indeterminateDuration` in the xml.

Including in your project
-------------------------

You can either add the library to your application as a library project or add the following dependency to your build.gradle:

```groovy
dependencies {
    compile 'com.jpardogo.googleprogressbar:library:(latest version)'
}
```

Developed By
------------

Javier Pardo de Santayana Gómez - <jpardogo@gmail.com>

<a href="https://twitter.com/jpardogo">
  <img alt="Follow me on Twitter"
       src="https://raw.github.com/jpardogo/ListBuddies/master/art/ic_twitter.png" />
</a>
<a href="https://plus.google.com/u/0/+JavierPardo/posts">
  <img alt="Follow me on Google+"
       src="https://raw.github.com/jpardogo/ListBuddies/master/art/ic_google+.png" />
</a>
<a href="http://www.linkedin.com/profile/view?id=155395637">
  <img alt="Follow me on LinkedIn"
       src="https://raw.github.com/jpardogo/ListBuddies/master/art/ic_linkedin.png" />

License
-----------

    Copyright 2013 Javier Pardo de Santayana Gómez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

[1]: https://raw.githubusercontent.com/jpardogo/GoogleProgressBar/master/art/GoogleProgressBar.gif
[2]: https://github.com/jpardogo/GoogleProgressBar/blob/master/library/src/main/java/com/jpardogo/android/googleprogressbar/library/GoogleProgressBar.java#L129
