<script setup>

import {Avatar, EditPen, Menu} from "@element-plus/icons-vue";
</script>

<template>
  <el-menu
      active-text-color="#ffd04b"
      background-color= "#475669"
      class="el-menu-vertical-demo"
      default-active="1"
      text-color="#fff"
      style="width: 201px"
  >
    <el-sub-menu index="1">
      <template #title>
        <el-icon><Avatar/></el-icon>
        <span>学生考试信息</span>
      </template>
      <el-menu-item-group title="CET-6">
        <el-menu-item index="1-1">总览</el-menu-item>
        <el-menu-item index="1-2">学生具体信息</el-menu-item>
      </el-menu-item-group>
    </el-sub-menu>
    <el-sub-menu index="2">
      <template #title>
        <el-icon><EditPen/></el-icon>
        <span>考试安排信息</span>
      </template>
      <el-menu-item-group title="CET-6">
        <el-menu-item index="2-1">总览</el-menu-item>
        <el-menu-item index="2-2">考场具体信息</el-menu-item>
        <el-menu-item index="2-3">我的考场安排</el-menu-item>
      </el-menu-item-group>
    </el-sub-menu>
    <el-menu-item index="3">
      <el-icon><Menu /></el-icon>
      <span>考试阅卷系统</span>
    </el-menu-item>
  </el-menu>
</template>

<style scoped>

</style>