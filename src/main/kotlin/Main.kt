package com.fabidi.webapp

import org.apache.catalina.LifecycleException
import org.apache.catalina.startup.Tomcat
import org.apache.catalina.webresources.DirResourceSet
import org.apache.catalina.webresources.StandardRoot
import java.io.File
import javax.servlet.ServletException

class Main {
    companion object {

        @Throws(LifecycleException::class, InterruptedException::class, ServletException::class)
        @JvmStatic
        fun main(args: Array<String>) {
            val tomcat = Tomcat()
            tomcat.setPort(8080)

            val ctx = tomcat.addWebapp("", File(".").absolutePath)

            val additionWebInfClasses = File("lib")
            val resources = StandardRoot(ctx)
            resources.addPreResources(
                    DirResourceSet(resources, "/WEB-INF/lib", additionWebInfClasses.absolutePath, "/"))

            ctx.resources = resources

            tomcat.start()
            tomcat.server.await()
        }
    }
}
