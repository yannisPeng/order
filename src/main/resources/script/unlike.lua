--- 获取key
local key = KEYS[1]
--- 获取value
local val = KEYS[2]
--- 如果redis找不到这个key就去插入
if redis.call("hget", key , val) == 1 then
    --- 如果插入成功，就去设置过期值
    if redis.call("hdel", key, val) then
    end
    return false
else
    return false
end