grails.plugin.location.publish = "../../.."

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits "global"
    log "warn"
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
    }
    dependencies {
    }
}

grails {
    plugin.repos.distribution.myRepo = "svn+ssh://localhost:23445/svn"
    project {
        work.dir = "target"

        portal.'my-portal' = "http://beta.grails.org/plugin/"

        repos {
            maven1 {
                url = "http://rimu:8081/artifactory/plugins-releases-local"
                username = "admin"
                password = "password"
            }

            'maven1-snapshots' {
                type = "maven"
                url = "http://rimu:8081/artifactory/plugins-snapshots-local"
                username = "dilbert"
                password = "test"
                custom = {
                    authentication username: "admin", password: "password"
                }
                portal = "my-portal"
            }

            svn1 {
                type = "svn"
                url = "http://peter:password@svn.codehaus.org/grails-plugins"
                portal = "grailsCentral"
            }

            bad {
                type = "svn"
                url = "svn+ssh://svn.codehaus.org/grails-plugins"
                username = "peter"
            }
        }
    }
}
