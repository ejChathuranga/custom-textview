# Custom TextView

## Welcome to Customizable TextView Component on Android

<p align="center">
  <a href="https://opensource.org/licenses/Apache-2.0"><img alt="License" src="https://img.shields.io/badge/License-Apache%202.0-blue.svg"/></a>
  <a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

CustomTextView is a Customizable text view component that can use on Android. This component is a child of `AppCompatTextView` and almost all functionalities are inherited from `TextView`. Using the `CustomTextView` component, you can add a dotted underline and that can be customized.

## Download

CustomTextView is available on `mavenCentral()`.

#### Groovy(Java)
```groovy
implementation 'io.github.ejchathuranga:custom-textview:1.0.01'
```
#### Kotlin
```kotlin
implementation("io.github.ejchathuranga:custom-textview:1.0.01")
```

## Usage
```
<io.github.ejchathuranga.ctv.CustomTextView
                android:id="@+id/ctv"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:ctvUnderlineColor="0xFFFF00FF"
                app:underlineWidth="10.5"
                app:ctvUnderlinePadding="20"
                app:ctvUnderLineDotWidth="40"
                app:ctvUnderLineDotSpace="20" />
                
```

```java
CustomTextView ctv = findViewById(R.id.ctv);
```

### Functionalities 

```java
ctv.setUnderLineColor(0xFFFF00FF);
ctv.setUnderlineDotWidthAndSpace(55f, 5f);
ctv.setUnderlineThickness(55);
ctv.setUnderlinePadding(30);
ctv.reset();
```
