## 关于Presentation

Presentation是一种特殊的对话框，其目的是在辅助显示器上展示内容,通过它可以执行多屏异显的操作，通过DisplayManager来获取屏幕管理，进而获取对应的屏幕个数。

## 注意事项

如果应用未配置成系统级应用，需要手动打开多屏权限：

```
应用和通知-> 高级 -> 特殊应用权限 -> 显示在其他应用上层 ->对分屏的软件进行配置
```

另外的，针对于高于Android O的版本，需要添加权限：TYPE_APPLICATION_OVERLAY

![](/art/ic_presentation_demo——2.png)

![](/art/ic_presentation_demo.png)
