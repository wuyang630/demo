//index.js
//获取应用实例
var app = getApp()
// import toLevel from '../../utils/utils'
var utils = require('../../utils/util.js')

let text = ['我是个测试文本', '你看到了这个', '为自己配置保险是一个男人的责任', '在外国，人们是先买保险，后买理财，\n在中国，人们是先买理财，再买理财，\n因为中国人要钱不要命', '你知道吗？\n你给爱车上了成千上万的保险，却没有一项是保护自己的，这难道是真爱？']

function showText() {
  return text[parseInt(Math.random() * text.length)]
}

Page({
  data: {
    text: '',
    age:0,
    income:0,
    ratio:1,
    debt:0,
    children:0,
    parents:2,
    // result:{}
  },

  onShow:function() {
      this.setData({
        text:showText()
      })
  },

  //事件处理函数
  bindViewTap: function() {
    console.log(this.data)
    let result = {}
    result.heavy = utils.toLevel((this.data.income * 2  + (this.data.children + this.data.parents)/2))
    result.life = utils.toLevel(this.data.debt*this.data.ratio + (this.data.children + this.data.parents) * this.data.income)
    result.accident = utils.toLevel(this.data.debt*this.data.ratio + (this.data.children + this.data.parents + (60-this.data.age)/6)*2*this.data.income )
    // this.setData({
      // result: result
    // })
    wx.navigateTo({
      // url: '../result/result?result='+JSON.stringify(this.data.result)
      url: '../result/result?result='+JSON.stringify(result)
    })
  },

  setAge: function(e) {
    this.data.age = Number.parseInt(e.detail.value)
  },
  setIncome: function(e) {
    this.data.income = Number.parseFloat(e.detail.value)
  },
  setRatio: function(e) {
    this.data.ratio = Number.parseFloat(e.detail.value)/100
  },
  setDebt: function(e) {
    this.data.debt = Number.parseFloat(e.detail.value)
  },
  setChildren: function(e) {
    this.data.children = Number.parseInt(e.detail.value)
  },
  setParents: function(e) {
    this.data.parents = Number.parseInt(e.detail.value)
  },

})
