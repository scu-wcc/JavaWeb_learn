<template>
    <div>
        <el-table :data="tableData" style="width: 100%">
        <el-table-column prop="date" label="日期" width="180"></el-table-column>

        <el-table-column prop="name" label="姓名" width="180"></el-table-column>

        <el-table-column prop="address" label="地址"></el-table-column>
    </el-table>

    <br><br>
    <el-pagination
    @size-change="handleSizeChange"
    @current-change="handleCurrentChange"

     background
    layout="total, sizes,prev, pager, next, jumper, slot"
     :total="1000">
    </el-pagination>


    <el-button type="text" @click="dialogTableVisible = true">打开嵌套表格的 Dialog</el-button>

<el-dialog title="收货地址" :visible.sync="dialogTableVisible">
  <el-table :data="gridData">
    <el-table-column property="date" label="日期" width="150"></el-table-column>
    <el-table-column property="name" label="姓名" width="200"></el-table-column>
    <el-table-column property="address" label="地址"></el-table-column>
  </el-table>
</el-dialog>

<br><br>
<el-button type="text" @click="dialogFormVisible = true">打开嵌套Form的 Dialog</el-button>
 <el-dialog title="提交信息" :visible.sync="dialogFormVisible">

    <el-form ref="form" :model="form" label-width="80px">
  <el-form-item label="活动名称">
    <el-input v-model="form.name"></el-input>
  </el-form-item>
  <el-form-item label="活动区域">
    <el-select v-model="form.region" placeholder="请选择活动区域">
      <el-option label="区域一" value="shanghai"></el-option>
      <el-option label="区域二" value="beijing"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="活动时间">
    <el-col :span="11">
      <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
    </el-col>
    <el-col class="line" :span="2">-</el-col>
    <el-col :span="11">
      <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
    </el-col>
  </el-form-item>
  
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button @click="dialogFormVisible= false">取消</el-button>
  </el-form-item>
</el-form>

</el-dialog>

    </div>


</template>

<script>
export default {
    data() {
        return {

            gridData: [{
          date: '2016-05-02',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-04',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-01',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }, {
          date: '2016-05-03',
          name: '王小虎',
          address: '上海市普陀区金沙江路 1518 弄'
        }],
        dialogTableVisible: false,
        dialogFormVisible: false,


        form: {
          name: '',
          region: '',
          date1: '',
          date2: '',
        },

            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
            }, {
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1516 弄'
            }]
        };
    },
    methods: {
        handleSizeChange(val){
            alert("当前页面展示大小改变："+val)
        },
        
        handleCurrentChange:function(val){
            alert("当前页面跳转至："+val)
        },

        onSubmit:function(){
            //将对象转换成JSON
            alert(JSON.stringify(this.form))
            console.log(this.form)
        }
    }
}
</script>