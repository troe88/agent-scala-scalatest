/*
 * Copyright 2016 EPAM Systems
 *
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/agent-scala-scalatest
 *
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.epam.reportportal.scalatest.service

import com.epam.reportportal.guice.Injector
import com.epam.reportportal.scalatest.providers.TestContextProvider
import com.google.common.base.{Supplier, Suppliers}
import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}


class ReporterServiceTest extends FunSuite with Matchers with BeforeAndAfter{

  private var reporterService: Supplier[ReporterServiceImp] = _

  before {
    reporterService = Suppliers.memoize(new Supplier[ReporterServiceImp] {
      override def get() = Injector.getInstance.getChildInjector(new TestContextProvider).getBean(classOf[ReporterServiceImp])
    })
  }

  test("Testing ReporterService is created ") {
    reporterService should not be (null)
  }
}
