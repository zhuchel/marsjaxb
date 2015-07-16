def findObjectCache(objectCacheName):
  print "findObjectCache", objectCacheName
  objectCaches = AdminConfig.list('CacheInstance', AdminConfig.getid( '/Cell:' + AdminControl.getCell() + '/'))
  for objectCache in objectCaches.splitlines():
    print "Object cache", objectCache
    if(objectCache.find(objectCacheName) > -1):
      return objectCache
      
def deleteObjectCache(cacheName):
  objectCache = findObjectCache(cacheName)
  if not objectCache == None:
    AdminConfig.remove(objectCache)
    AdminConfig.save()
    print " Object Cache: ",cacheName, " deleted"
  else:
    print " Object Cache: ",cacheName, " not found"

def getRootCacheProvider():
  cacheProvs = AdminConfig.list('CacheProvider', AdminConfig.getid( '/Cell:' + AdminControl.getCell() + '/')).splitlines()
  arrayLen = len(cacheProvs)
  return cacheProvs[arrayLen-1]
    
def createObjectCache(cacheName, jndiName):
  deleteObjectCache(cacheName)
  try:
      newObjCache = AdminTask.createObjectCacheInstance('"' + getRootCacheProvider() + '"', '[-name ' + cacheName + ' -jndiName ' + jndiName + ']')
      newDiskCachePolicy = AdminConfig.create('DiskCacheEvictionPolicy', '"' + newObjCache + '"', '[]')
      newDRSSettings = AdminConfig.create('DRSSettings', '"' + newObjCache + '"', '[]')
      AdminConfig.modify(newDiskCachePolicy, '[[algorithm "NONE"] [lowThreshold "70"] [highThreshold "80"]]')
      newDiskCachePerfSetings = AdminConfig.create('DiskCacheCustomPerformanceSettings', '"' + newObjCache + '"', '[]')
      AdminConfig.modify(newDiskCachePerfSetings, '[[maxBufferedTemplates "100"] [maxBufferedDependencyIds "10000"] [maxBufferedCacheIdsPerMetaEntry "1000"]]')
      AdminConfig.modify(newObjCache, '[[defaultPriority "1"] [disableDependencyId "false"] [name "' + cacheName + '"] [enableCacheReplication "true"] [diskCachePerformanceLevel "BALANCED"] [flushToDiskOnStop "false"] [enableDiskOffload "false"] [replicationType "PUSH"] [diskCacheEntrySizeInMB "0"] [jndiName "' + jndiName +'"] [cacheSize "100"] [diskCacheSizeInGB "0"] [pushFrequency "1"] [useListenerContext "false"] [diskCacheCleanupFrequency "0"] [diskCacheSizeInEntries "0"]]')
      AdminConfig.save()
      print " Object Cache: ",cacheName, " created with > JNDI: ", jndiName
  except:
    print " Object Cache: ",cacheName, " already exists. please verify"
    
def isApplicationRunning(applicationName, serverName, nodeName) :
    return AdminControl.completeObjectName("type=Application,name=%s,process=%s,node=%s,*" % (applicationName, serverName, nodeName)) != ""    

createObjectCache('marsProcessCache', 'services/mars/cache/process')

print 'done'