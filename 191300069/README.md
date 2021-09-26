# W02

### 任务一

##### 类图：

![](https://github.com/halipai/MYIMAGES/raw/main/java_W02/character1.png?raw=true)

##### 时序图：

![](https://github.com/halipai/MYIMAGES/raw/main/java_W02/timeline.png?raw=true)

##### 从面向对象编程角度理解`example`的设计理念

###### 将代码模块化

将任务分解：

- 进行操作的对象`(Line)`
- 对象的内容`(Gourd)`
- 操作的控制者`(Geezer)`
- 控制者的手段`(Sorter)`
- 一个具体的排序手段`(BubbleSorter)`，

在每一个对象的眼中，其他对象都是抽象的概念，不需要考虑具体的内容，也不允许改变其他对象的内容，调用即可。并且将数据封装，对象里面的一些内容只允许自己访问，所以增强了程序的可靠性

所以在`main`函数中将这些对象复合，简单轻松地就能理解程序的意图和工作原理

###### 可以改进之处

写代码最好按照private,public的顺序，将变量，函数和类按顺序写好，将`override`写在最后，因为按照`example`写类图的时候找得好烦

`Gourd`手写枚举变量有点复杂，应该简化

在`Geezer.java`中

```
String[] sortSteps = this.parsePlan(sorter.getPlan());

++System.out.println(line.toString());

--for (String step : sortSteps) {
--    this.execute(step);
--    System.out.println(line.toString());
--    log += line.toString();
--    log += "\n[frame]\n";
--}

++if(!sortSteps[0].isEmpty()){
++for (String step : sortSteps) {
++    this.execute(step);
++	  System.out.println(line.toString());
++	  log += line.toString();
++	  log += "\n[frame]\n";
++		}
++	}
```

example里的line若是起始已经排好序就会报错，并且第一个输出的可视化队列不是起始队列而是sort一次后的队列，修改完后第一个输出的队列是起始队列且不排序不会报错

### 任务二

##### 类图：

![](https://github.com/halipai/MYIMAGES/raw/main/java_W02/character2.png?raw=true)

##### 快速排序：

[![asciicast](https://asciinema.org/a/438068.png)](https://asciinema.org/a/438068)

##### 冒泡排序：

[![asciicast](https://asciinema.org/a/438063.png)](https://asciinema.org/a/438063)

### 任务三

##### 类图：

![](https://github.com/halipai/MYIMAGES/raw/main/java_W02/character3.png?raw=true)

##### 快速排序：

[![asciicast](https://asciinema.org/a/438067.png)](https://asciinema.org/a/438067)

##### 冒泡排序：

[![asciicast](https://asciinema.org/a/438062.png)](https://asciinema.org/a/438062)

