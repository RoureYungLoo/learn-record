<script setup>

import {ref} from "vue";

const text = ref("123")
const name = ref("v-model binding")
const prompts = ref("这是提示信息")
const message = ref("")
const msgs = ref("")
const poetry = ref("你好\n我是\n风")
const check = ref(true)
const aihao = ref(["围棋"])
const selected = ref("未选择")
const iosSelected = ref("")
const langs = ref(['Java'])
const lang_selected = ref(['c'])
const options = ref([{
  text: 'java语言',
  value: 'java'
},
  {
    text: 'C语言',
    value: 'c'
  },
  {
    text: 'Python语言',
    value: 'python'
  }
])
const picked = ref("")
const picker = ref("")
const checker = ref("已选择")
const toggle = ref(false)
// const opt1 = ref("男")
// const opt2 = ref("女")
const opt1 = ref(1)
const opt2 = ref(2)
const checker1 = ref("二七塔")
const checker2 = ref("西湖")
const checker3 = ref("东方明珠")
const checker4 = ref("中原福塔")
const yesValue = ref("勾选北京")
const noValue = ref("取消北京'")
const trueValue = yesValue
const falseValue = noValue
const city_radio = ref("苏州")
const city_checkbox = ref([])
const cates = ref([])
const direction = ref("{占位}")
const east = ref("东方")
const west = ref("西方")
const north = ref("北方")
const south = ref("南方")
const mymsg = ref("")
const first = ref("第一")
const second = ref("第二")
const pick = ref('')
const Counter = ref({number: 123})

const manualBinding = (event) => {
  // event => text=event.target.value
  text.value = event.target.value
  console.log("手动实现双向绑定", event.target)
}

function inputHandler(event) {
  text.value = event.target.value
  console.log(text.value)
}

function handler(event) {
  console.log("current input value is " + event.target.value)
}

function getvalue() {
  console.log(picker.value)
  console.log(checker.value)
}

function onWzqChange(e) {
  console.log(e)
}
</script>


<template>
  <!-- 手动实现双向数据绑定 -->
  <input type="text" v-bind:value="text" v-on:input="event => text=event.target.value"><br>
  <input type="text" v-bind:value="text" @:input="manualBinding"><br>

  <!-- 双向数据绑定 v-model-->
  <input type="text" :value="text" @input="inputHandler($event)">
  <p>{{ text }}</p>

  <input type="text" v-model="name" value="name" placeholder="input name"/>
  <input type="text" v-model="name" placeholder="input name"/>
  <h2>{{ name }}</h2>

  <!-- 文本 -->
  <!-- v-model 双向绑定 input 标签的 value 属性 , 并监听input事件-->
  <input type="text" v-model="message" :placeholder="prompts">
  <!-- 监听IME语言输入(中文、日文、韩文等等) -->
  <input type="text" :placeholder="prompts" @input="handler($event)">
  <p>{{ message }}</p>

  <!-- 多行文本 -->
  <!-- v-model 双向绑定 textarea 标签的 value 属性 并监听input事件-->
  <p>输入多行文本：</p>
  <textarea v-model="msgs" :placeholder="msgs" cols="30" rows="5"></textarea>
  <p style="white-space: pre-line;">{{ msgs }}</p>
  <hr>
  <textarea cols="30" rows="5">{{poetry}}</textarea>  <!-- 这是错误的写法, textarea 不能写 {{}} 表达式, 会破话响应式 -->
  <textarea cols="30" rows="5" v-model="poetry"></textarea><br>

  <!-- 复选框 绑定 checked 属性,监听 change 事件-->
  <p>爱好：</p>
  <input type="checkbox" id="xaingqi" name="hobby" v-bind:checked="check" value="象棋" v-model="aihao"/>
  <label for="xaingqi">象棋</label>
  <input type="checkbox" name="hobby" id="weiqi" value="围棋" v-model="aihao">
  <label for="weiqi">围棋</label>
  <input type="checkbox" name="hobby" id="wuziqi" value="五子棋" v-model="aihao" @change="onWzqChange($event)">
  <label for="wuziqi">五子棋</label>

  <input type="checkbox" id="swimming" name="hobby" v-model="aihao" value="swimming"/>
  <label for="swimming">游泳</label>
  <input type="checkbox" id="running" name="hobby" v-model="aihao" value="running"/>
  <label for="running">跑步</label>

  <br>已经选择的爱好: <br>{{ aihao }}

  <div>
    <!-- 单选按钮  绑定 checked 属性,监听 change 事件-->
    <input type="radio" id="zz" value="郑州" v-model="city_radio"/>
    <label for="zz">郑州</label>
    <input type="radio" id="sz" value="苏州" v-model="city_radio"/>
    <label for="sz">苏州</label>
    <input type="radio" id="xz" value="徐州" v-model="city_radio"/>
    <label for="xz">徐州</label>
    <p>你选择的城市：{{ city_radio }}</p>
  </div>
  <!-- 单项选择器, 单项下拉菜单 , 绑定 value 属性,监听 change 事件  -->
  <div>已选择：{{ selected }}</div>
  <select v-model="selected">
    <option value="未选择" disabled>未选择</option>
    <option value="1">A</option>
    <option value="第二项">B</option>
    <option value="third">C</option>
  </select>

  <!-- iOS 单项选择器 -->
  <div>iOS 已选择：{{ iosSelected }}</div>
  <select v-model="iosSelected" @change="console.log($event.target)">
    <option disabled value="">请选择</option>
    <option value="1">A</option>
    <option value="第二项">B</option>
    <option value="third">C</option>
  </select>
  <br>
  <!-- 多项选择器 -->
  <div></div>
  <label for="langs">多项选择器 已选择：{{ langs }}</label><br>
  <select name="langs" id="langs" multiple v-model="langs">
    <option>Java</option>
    <option>C语言</option>
    <option>Python</option>
    <option>Go语言</option>
    <option>JavaScript</option>
  </select>
  <br>
  <!-- 使用vfor渲染多选下拉菜单的option -->
  <div>
    <label for="vforlangs">使用vfor渲染的多选下拉菜单: {{ lang_selected }}</label><br>
    <select id="vforlangs" name="vforlangs" v-model="lang_selected" multiple>
      <!-- <select v-model="lang_selected" > -->
      <option v-for="option in options" :value="option.value">
        {{ option.text }}
      </option>
    </select>
  </div>

  <!-- 值绑定 -->
  <div>
    <div>
      <input type="radio" v-model="picked" value="保密">
      <input type="radio" v-model="picked" :value="opt1">
      <input type="radio" v-model="picked" :value="opt2"><br>
      <input type="checkbox" v-model="toggle" :value="checker1"/>
      <input type="checkbox" v-model="toggle" :value="checker2"/>
      <div>{{ picked }}</div>
      <div>{{ toggle }}</div>
      <div @click="getvalue">点击查看</div>
    </div>
    <hr>
    <div> <!-- 复选框-->
      <input id="city1" type="checkbox" v-model="city_checkbox" value="city1" true-value="是" false-value="否"/>
      <label for="city1">城市1</label>

      <input id="city2" type="checkbox" v-model="city_checkbox" :value="checker2" true-value="是1" false-value="否1"/>
      <label for="city2">城市2</label>

      <input id="city3" type="checkbox" v-model="city_checkbox" :value="checker3"
             :true-value="yesValue"
             :false-value="noValue"/>
      <label for="city3">城市3</label>

      <p>{{ city_checkbox }}</p>

      <input id="cates" name="cates" type="checkbox" v-model="cates" :value="checker4"/>
      <label for="cates">{{ 111 }}</label>
      <!--      <input id="cates1" name="cates" type="checkbox" v-model="cates" true-value="yes" false-value="no"/>-->
      <!--      <label for="cates1">{{"yes/no"}} </label>-->
      <!--      <input id="cates2" name="cates" type="checkbox" v-model="cates" :true-value="trueValue"-->
      <!--             :false-value="falseValue"/>-->
      <label for="cates2">北京</label>
      <p>{{ cates }}</p>
    </div>
    <div>
      单选按钮:
      <input type="radio" v-model="pick" :value="first">
      <input type="radio" v-model="pick" :value="second">
      <p>{{ pick }}</p>
    </div>
    <hr>
    <div>
      <p>选择方向 已选{{ direction }}</p>
      <input id="e" type="radio" v-model="direction" :value="east" name="direction"/>
      <label for="e" style="padding: 0 10px">东</label>
      <input id="w" type="radio" v-model="direction" :value="west" name="direction"/>
      <label for="w" style="padding: 0 10px">西</label>
      <input id="n" type="radio" v-model="direction" :value="north" name="direction"/>
      <label for="n" style="padding: 0 10px">北</label>
      <input id="s" type="radio" v-model="direction" :value="south" name="direction"/>
      <label for="s" style="padding: 0 10px">南</label>
    </div>

    <div>
      下拉菜单
      <select v-model="selected">
        <option :value="Counter">{{ Counter.number }}</option>
      </select>
    </div>
    <div>
      <!--      <input type="text" v-model="mymsg" placeholder="v-model without .lazy"><br>-->
      <!-- 表单输入绑定延迟更新 v-model.lazy   -->
      <!--      <input type="text" v-model.lazy="mymsg" placeholder="v-model.lazy"><br>-->
      <!-- 尝试转为数字, 转换失败则返回原值 -->
      <!--      <input type="text" v-model.number="mymsg"/>-->
      <!-- 去除两端空格, 中间的空格只保留一个     -->
      <input type="text" v-model.trim="mymsg"/>
      <p>{{ typeof mymsg }}</p>
      <p>{{ mymsg }}</p>
    </div>

    <!-- 组件上的vmodel ,请跳转组件相关的内容   -->

    <!--    v-model 会忽略任何表单元素上初始的 value、checked、selected attribute。它将始终将当前绑定的 JavaScript 状态视为数据的正确来源。-->
  </div>

</template>

<style scoped>
</style>
