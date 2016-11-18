#深入Activity，Activity启动模式LaunchMode完全解析
>在平时的开发中，我们可能会了解到Activity的任务栈还有Activity的启动模式。那么Activity的启动模式都分别是怎么样的呢？如果设置了这些启动模式对任务栈有事么影响
，还有就是这么启动模式在实际的开发中有事么应用呢？这里用图例和demo来分析一下Activity的启动模式。

Demo图
![Demo图](https://github.com/linglongxin24/ActivityLaunchMode/blob/master/screenshorts/device.png?raw=true)

#1.Standard：标准启动模式
Activity的默认模式，所有的Activity元素遵循先进后出的进栈出栈的特性，这种的比较简单
>启动顺序：A->B->C
>回退顺序：C->B->A.
![Standard](https://github.com/linglongxin24/ActivityLaunchMode/blob/master/screenshorts/standard.png?raw=true)
#2.SingleTop:栈顶复用模式
栈顶复用模式，如果想要打开的activity在任务栈的栈顶已经存在，就不会创重新建新的实例，而是调用该Activity的 onNewIntent() 方法。避免栈顶的activity被重复的创建。
>例如A.B启动模式为Standard，C启动模式为SingleTop
>启动顺序：A->B->C—>C
>回退顺序：C->B->A.而不是C->C->B->A

![SingleTop](https://github.com/linglongxin24/ActivityLaunchMode/blob/master/screenshorts/singleTop.png?raw=true)
应用如下：
* 点击通知栏重复打开Activity的问题
在[全新的Android通知栏,已抛弃setLatestEventInfo,兼容高版本](http://blog.csdn.net/linglongxin24/article/details/53166551) 这篇文章里面
我们打开一个通知栏，点击通知栏默认打开MainActivity，有一个问题，就是如果不设置MainActivity的launchMode，就会每次点击通知栏的时候会重新打开一个Activity。
我们可以将MainActivity的启动模式设置为SingleInstance，就不会再重新打开MainActivity，而是调用MainActivity的onNewIntent() 方法。
* 可以解决按钮重复点击的问题（当然这种启动模式不是为了去解决这个问题在这里这是说为了用这么应用去说明SingleTop启动模式）。

#3.SingleTask:栈内复用模式
如果想要启动的Activity在当前栈内启动之后，该activity只会在任务栈里面存在一个实例。如果要再次打开这个activity，在任务栈里面如果已经存在，就不会创建新的activity，
而是复用栈内的这个已经存在的activity，调用改Activity的 onNewIntent() 方法，并且清空这个activity任务栈上面所有的activity。
>例如A.C.D启动模式为Standard，B启动模式为SingleTask
>启动顺序：A->B->C—>D—>B
>回退顺序：B->A.而不是B—>D->C->B->A

![SingleTop](https://github.com/linglongxin24/ActivityLaunchMode/blob/master/screenshorts/singleTask.png?raw=true)
应用如下：如果从主页去登录，然后去注册，注册完成如果直接回去主页，可以将主页的launchMode设置为SingleTask。直接从注册跳到主页即可，不用去关心LoginActivity是否关闭，还是什么时候关闭。


#4.SingleInstance：单一实例模式
在整个Android系统中(可能会有很多任务栈)里面只有一个实例存在。不同的应用程序app去启动这个activity，就会共享公用同一个activity。
他会运行在自己单独的的任务栈里面，并且这个单独的任务栈里面只会存在着一个实例。而且这个单独的任务栈会在最底层。
应用场景：系统的发短信，打电话，来电，浏览器等。这种模式在平时很少去使用，一般在Launcher中可能会用到。
>例如A.C启动模式为Standard，B启动模式为SingleInstance
>启动顺序：A->B->C；注意：此时产生了两个任务栈，B产生了一个新的任务栈，并处于其他任务栈的下面。
>回退顺序：C->A->B.而不是C->B->A

![SingleTop](https://github.com/linglongxin24/ActivityLaunchMode/blob/master/screenshorts/singleInstance.png?raw=true)

#5.[GitHub](https://github.com/linglongxin24/ActivityLaunchMode)