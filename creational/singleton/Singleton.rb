
require 'singleton'

class Object
	include Singleton

end

Object.new
# NoMethodError: private method `new' called for Shop:Class

Object.instance.object_id
# 5659219
