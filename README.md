#深入Activity，Activity启动模式LaunchMode完全解析

#1.Standard：标准启动模式
Activity默认模式，所有的Activity遵循元素进栈出栈的特性，例如进栈序列为A->B->C->D,D呈现在页面上，按返回键出栈顺序久违D->C->B->A.

```flow
st=>start: Start
i=>inputoutput: 输入年份n
cond1=>condition: n能否被4整除？
cond2=>condition: n能否被100整除？
cond3=>condition: n能否被400整除？
o1=>inputoutput: 输出非闰年
o2=>inputoutput: 输出非闰年
o3=>inputoutput: 输出闰年
o4=>inputoutput: 输出闰年
e=>end
st->i->cond1
cond1(no)->o1->e
cond1(yes)->cond2
cond2(no)->o3->e
cond2(yes)->cond3
cond3(yes)->o2->e
cond3(no)->o4->e
```

#2.SingleTop:栈顶复用模式
栈顶复用模式，如果要开启的activity在任务栈的顶部已经存在，就不会创建新的实例，而是调用 onNewIntent() 方法。避免栈顶的activity被重复的创建。
#3.SingleTask:栈内复用模式
如果要启动的Activity在当前栈内启动，activity只会在任务栈里面存在一个实例。如果要激活的activity，在任务栈里面已经存在，就不会创建新的activity，而是复用这个已经存在的activity，调用 onNewIntent() 方法，并且清空这个activity任务栈上面所有的activity。
#4.SingleInstance：单一实例模式
整个手机操作系统里面只有一个实例存在。不同的应用去打开这个activity 共享公用的同一个activity。他会运行在自己单独，独立的任务栈里面，并且任务栈里面只有他一个实例存在。应用场景：呼叫来电界面。这种模式的使用情况比较罕见，在Launcher中可能使用。或者你确定你需要使Activity只有一个实例。