# UniversalPreferences
UniversalPreferences is simple Android library that allows you to use Shared Preferences in an easy way. 

This library allows you to easily to store and retrive values from SharedPreferences without creating lots of boilerplate.



# Usage

Add to your module's build.gradle:
```
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
and to your app build.gradle:
```
dependencies {
    compile 'com.github.zookey:universalpreferences:0.0.3'
}
```

First you do need to initalize this libarary inside onCreate of the Application class of your project.
```Java
public class UniversalPreferencesApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UniversalPreferences.initialize(this);
    }
}
```
Now you can use UniversalPreferences library in any class of your project.

UniversalPreferences library is "universal" at accepting object types, so there is only one method to store and only one method to retrive values.

##### Store and retrive String
```Java
UniversalPreferences.getInstance().put("string", "some value");
String stringValue = UniversalPreference.getInstance().get("string", "");
```
##### Store and retrive Integer
```Java
UniversalPreferences.getInstance().put("int", 30);
int integerValue = UniversalPreference.getInstance().get("int", 0);
```

##### Store and retrive Float
```Java
UniversalPreferences.getInstance().put("float", 3.0f);
float valueFloat = UniversalPreference.getInstance().get("float", 0.0f);
```

##### Store and retrive Boolean
```Java
UniversalPreferences.getInstance().put("bool", true);
boolean bool = UniversalPreference.getInstance().get("bool", false);
```

##### Store and retrive Set<String>
```Java
Set<String> set = new HashSet<String>();
set.add("test 1");
set.add("test 2");
UniversalPreferences.getInstance().put("set", set);
Set<String> savedSet = UniversalPreference.getInstance().get("set", new HashSet<String>);
```
