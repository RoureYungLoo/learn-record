local _M = {}
_M.name = 'calc'
print('calc.lua: 加载模块 ' .. _M.name)

function _M.add(a, b) return a + b end

function _M.sub(a, b) return a - b end

function _M.mul(a, b) return a * b end

function _M.div(a, b) return a / b end

return _M
