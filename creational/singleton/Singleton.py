
class Singleton:

	__instance = None

	def __new__(cls):
		if cls.__instance is None:
			cls.__instance = super().__new__(cls)
		return cls.__instance



singleton_obj1 = Singleton()
singleton_obj2 = Singleton()

print(singleton_obj1)
print(singleton_obj2)