//logs.js
var util = require('../../utils/util.js')
Page({
  data: {
    result : {} 
  },
  onLoad: function (options) {
    this.setData({
      // reuslt: (JSON.parse(wx.getStorageSync('meta')) || 0 )
      result: JSON.parse(options.result)
      })
  }
})
