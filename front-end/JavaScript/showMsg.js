/* // 导出方式一
 export function simpleMessage (){
 	console.log("simpleMessage")
 }
 
 export function complexMessage(){
 	console.log("complexMessage")
 }
 // 假设这里有10000个函数 */


/* // 导出方式二
function simpleMessage() {
	console.log("simpleMessage")
}

function complexMessage() {
	console.log("complexMessage")
}

export {
	simpleMessage,
	complexMessage
} */

/* // 导出方式三
function simpleMessage() {
	console.log("simpleMessage")
}

function complexMessage() {
	console.log("complexMessage")
}

export {
	simpleMessage as sm,
	complexMessage as cm 
} */

// 导出方式四 ： 默认导出
function simpleMessage() {
	console.log("simpleMessage")
}

function complexMessage() {
	console.log("complexMessage")
}

export default {
	simpleMessage,
	complexMessage
}

