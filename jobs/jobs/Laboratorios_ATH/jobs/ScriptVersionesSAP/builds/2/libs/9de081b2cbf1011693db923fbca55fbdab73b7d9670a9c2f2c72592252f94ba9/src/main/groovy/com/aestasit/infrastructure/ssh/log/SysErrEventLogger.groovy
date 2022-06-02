/*
 * Copyright (C) 2011-2020 Aestas/IT
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.aestasit.infrastructure.ssh.log

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

/**
 * Standard system output logger.
 *
 * @author Andrey Adamovich
 *
 */
@CompileStatic
@TypeChecked
class SysErrEventLogger implements EventLogger {

  void info(String message) {
    System.err.println "$message"
  }

  void warn(String message) {
    System.err.println "WARN: $message"
  }

  void debug(String message) {
    System.err.println "DEBUG: $message"
  }

  void stdOutput(String line) {
    System.err.println "$line"
  }

  void errOutput(String line) {
    System.err.println "$line"
  }

  void progress(String progress) {
  	System.err.print progress
  }

  void progressEnd() {
    System.err.println()
  }

}
