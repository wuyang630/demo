function formatTime(date) {
  var year = date.getFullYear()
  var month = date.getMonth() + 1
  var day = date.getDate()

  var hour = date.getHours()
  var minute = date.getMinutes()
  var second = date.getSeconds()


  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

function formatNumber(n) {
  n = n.toString()
  return n[1] ? n : '0' + n
}

function toLevel(n) {
  if( n < 100) {
    return (Number.parseInt(n/10)+1)*10 
  } else {
    return (Number.parseInt(n/100)+1)*100 
  }
}

module.exports = {
  formatTime: formatTime,
  toLevel: toLevel
}
