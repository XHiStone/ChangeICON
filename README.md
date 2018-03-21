# ChangeICON
支持更换Launcher的ICON图标
先看看效果图吧<br>
![image](https://github.com/18337129968/ChangeICON/blob/master/photo/ChangeICON.gif)<br>
##实现原理
###1、activity-alias
activity-alias属性，这个属性可以用于给Activity创建多个不同的入口
###2、PackageManager
PackageManager是一个大统领类，可以管理所有的系统组件，当然这个就要追述到PackageMangerService服务对Apk的解析，例如解析AndroidManifest.xml文件，得到相应应用四大组件相关信息，然后分发到PackageManager由PackageManager统一管理，ComponentName是用来获取当前应用组件然后由PackageManger设置组件属性。
```
 pManager.setComponentEnabledSetting(componentName,
                PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
                PackageManager.DONT_KILL_APP);
```
好了知道以上两个就解决了切换Launcher图标方法了



