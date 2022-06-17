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
package com.aestasit.infrastructure.ssh

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

/**
 * Configuration object holding options used for EXEC (remote command execution) functionality.
 *
 * @author Andrey Adamovich
 *
 */
@CompileStatic
@TypeChecked
class ExecOptions extends CommonOptions {

  Boolean showOutput       = true
  Boolean showCommand      = true
  Boolean hideSecrets      = true
  Long maxWait             = 0

  Long succeedOnExitStatus = 0
  Boolean usePty           = true

  String prefix            = null
  String suffix            = null
  def escapeCharacters     = null
  List<String> secrets     = []

  ExecOptions() {
  }

  ExecOptions(ExecOptions opt1) {
    this.failOnError         = setValue(opt1?.failOnError, true)
    this.showOutput          = setValue(opt1?.showOutput, true)
    this.showCommand         = setValue(opt1?.showCommand, true)
    this.hideSecrets         = setValue(opt1?.hideSecrets, true)
    this.maxWait             = setValue(opt1?.maxWait, 0L)
    this.succeedOnExitStatus = setValue(opt1?.succeedOnExitStatus, 0L)
    this.usePty              = setValue(opt1?.usePty, true)
    this.prefix              = setValue(opt1?.prefix, null)
    this.suffix              = setValue(opt1?.suffix, null)
    this.escapeCharacters    = setValue(opt1?.escapeCharacters, null)    
    this.secrets             = setValue(opt1?.secrets, null)
  }

  ExecOptions(ExecOptions opt1, ExecOptions opt2) {
    this(opt1, opt2?.properties)
  }

  @SuppressWarnings('CyclomaticComplexity')
  ExecOptions(ExecOptions opt1, Map<String, ?> opt2) {
    this.failOnError         = setValue(opt2?.failOnError, opt1?.failOnError, true)
    this.showOutput          = setValue(opt2?.showOutput, opt1?.showOutput, true)
    this.showCommand         = setValue(opt2?.showCommand, opt1?.showCommand, true)
    this.hideSecrets         = setValue(opt2?.hideSecrets, opt1?.hideSecrets, true)
    this.maxWait             = setValue(opt2?.maxWait as Long, opt1?.maxWait, 0L)
    this.succeedOnExitStatus = setValue(opt2?.succeedOnExitStatus as Long, opt1?.succeedOnExitStatus, 0L)
    this.usePty              = setValue(opt2?.usePty, opt1?.usePty, true)
    this.prefix              = setValue(opt2?.prefix, opt1?.prefix, null)
    this.suffix              = setValue(opt2?.suffix, opt1?.suffix, null)
    this.escapeCharacters    = setValue(opt2?.escapeCharacters, opt1?.escapeCharacters, null)
    this.secrets             = setValue(opt2?.secrets, opt1?.secrets, null) as List<String>
  }

}
