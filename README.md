# DropDownTipsList 

[![](https://jitpack.io/v/tombayley/DropDownTipsList.svg)](https://jitpack.io/#tombayley/DropDownTipsList)

A simple library for showing app tips on Android


## Demo

| Example | In-app example |
| --- |:---:|
| [<img src="media/example.gif" width="250" />]() | [<img src="media/real_example.gif" width="250" />]() |


## How to include
Add the repository to your project build.gradle:
```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

And add the library to your module build.gradle:
```
dependencies {
    implementation 'com.github.tombayley:DropDownTipsList:Tag'
}
```




## Usage

### XML
Add the following code to your layout:
```
<com.tombayley.dropdowntipslist.DropDownList
    android:id="@+id/drop_down_list"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:attr_accentColor="@android:color/holo_blue_dark"
    app:attr_primaryTextColor="@android:color/black" />
```

In the parent viewgroup, add:
```
android:animateLayoutChanges="true"
```

### Kotlin
```
... 

val dropDownList: DropDownList = findViewById(R.id.drop_down_list)
dropDownList.preferences = preferences

val dropDownListItems = LinkedList<DropDownList.Item>()
var item: DropDownList.Item

item = DropDownList.Item(
    title = "Enter a title",
    description = "Enter a description",
    actionText = getString(android.R.string.ok),
    action = Runnable { 
        // ...
    }
)
item.setAppearAfter(appInstallTime, 0, "drop_list_example1")
dropDownListItems.add(item)

item = DropDownList.Item(
    title = "Example Item 2",
    description = "Example Description 2",
    actionText = "Action 2",
    action = Runnable { 
        // ...
    }
)
item.setAppearAfter(appInstallTime, 0, "drop_list_example2")
dropDownListItems.add(item)

item = DropDownList.Item(
    title = "Tip with no action",
    description = "Tip description"
)
item.setAppearAfter(appInstallTime, 12, "drop_list_example2")
dropDownListItems.add(item)

dropDownList.addAll(dropDownListItems)
```
