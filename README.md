# MultiLanguagePackage
多语言包方案
依赖Philology库


#### 1、在assets文件夹下放入对应的xml文件，里面有应用中所有text的翻译。
#### 2、在application的onCreate中初始化philology。
#### 3、如果要实现远程语言切换，只需远程下载对应语言xml文件替换assets中的文件，重启应用生效。
#### 4、如果想应用中生效，下载替换后，重新调用philology.init()方法，然后刷新所有界面

