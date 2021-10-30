# Custom TextView

## Welcome to Customizable TextView Component on Android

![GitHub](https://img.shields.io/github/license/ejchathuranga/custom-textview)
<a href="https://android-arsenal.com/api?level=21"><img alt="API" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>

CustomTextView is a Customizable text view component that can use on Android. This component is a child of `AppCompatTextView` and almost all functionalities are inherited from `TextView`. Using the `CustomTextView` component, you can add a dotted underline and that can be customized.

## Download

CustomTextView is available on `mavenCentral()`.

#### Groovy(Java)
```groovy
implementation 'io.github.ejchathuranga:custom-textview:1.1.0'
```
#### Kotlin
```kotlin
implementation("io.github.ejchathuranga:custom-textview:1.1.0")
```

## Usage/Initialization
```
<io.github.ejchathuranga.ctv.CustomTextView
                android:id="@+id/ctv"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                app:ctvUnderlineColor="0xFFFF00FF"
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
