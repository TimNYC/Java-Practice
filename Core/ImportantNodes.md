$1. Object creation.

$1.1 More commonly, the useful lifetime of a cache entry is less well defined, with
entries becoming less valuable over time. Under these circumstances, the cache
should occasionally be cleansed of entries that have fallen into disuse. This can be
done by a background thread (perhaps a Timer or ScheduledThreadPoolExecutor)
or as a side effect of adding new entries to the cache. The LinkedHashMap
class facilitates the latter approach with its removeEldestEntry method. For
more sophisticated caches, you may need to use java.lang.ref directly.
A third common source of memory leaks is listeners and other callbacks.
If you implement an API where clients register callbacks but don’t deregister them
explicitly, they will accumulate unless you take some action. The best way to
ensure that callbacks are garbage collected promptly is to store only weak references
to them, for instance, by storing them only as keys in a WeakHashMap.


$1.2 Typical examples of explicit termination methods are the close methods on
InputStream, OutputStream, and java.sql.Connection. Another example is
the cancel method on java.util.Timer, which performs the necessary state
change to cause the thread associated with a Timer instance to terminate itself
gently. Examples from java.awt include Graphics.dispose and Window.dispose.
These methods are often overlooked, with predictably dire performance
consequences.
