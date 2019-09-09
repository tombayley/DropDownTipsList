# DropDownTipsList 

[![](https://jitpack.io/v/tombayley/DropDownTipsList.svg)](https://jitpack.io/#tombayley/DropDownTipsList)

A simple library for showing app tips on Android.

Tips can be set to be shown after a specific amount of time.
They can also have an action button that will execute a provided Runnable and dismiss the tip when pressed.


Used in [this app](https://play.google.com/store/apps/details?id=com.tombayley.bottomquicksettings) (also shown in "In-app example" gif below)


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
    implementation 'com.github.tombayley:DropDownTipsList:1.1.0'
}
```




## Usage

### XML
Add the following code to your layout:
```xml
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
The title, description, action button text and action runnable can be set when creating an Item.

`setAppearAfter()` must also be called with:
- an initial time (Long) to start "counting down" from (e.g. app install time)
- a time in hours until the tip item is shown,
- a preference key which is used to store if an item has been dismissed (so it doesn't show again)

```kotlin
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




## Customising

### XML
XML attributes can be added to the DropDownList view:

| Attribute name | Type | Description |
| --- | --- | --- |
| attr_accentColor | reference / color | Color for number of tips and action button text |
| attr_primaryTextColor | reference / color | Color for all other elements. Some elements use a faded version of this color e.g. description text |
| attr_showAllExpanded | boolean | Default false. If true, all tips are shown and the header is hidden. Example in "In-app example" gif as the "Tips" activity |
| attr_keepSpaceIfEmpty | boolean | Default false. If true, space used by tips view is kept if list is empty |

### Kotlin
Don't remove the space used by the view if the tips list is empty:
```kotlin
dropDownList.keepSpaceIfEmpty = true
```
