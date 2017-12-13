/*
 * Copyright 2017 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may
 * not use this file except in compliance with the License. A copy of the
 * License is located at
 *
 *     http://aws.amazon.com/apache2.0/
 *
 * or in the "LICENSE" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package com.amazonaws.blox.dataservice.old.repository;

import com.amazonaws.blox.dataservice.old.exception.StorageException;
import com.amazonaws.blox.dataservice.old.model.Environment;
import com.amazonaws.blox.dataservice.old.model.EnvironmentVersion;
import com.amazonaws.blox.dataservicemodel.v1.old.exception.EnvironmentExistsException;
import com.amazonaws.blox.dataservicemodel.v1.old.exception.EnvironmentTargetRevisionExistsException;
import java.util.List;

/** Methods for interacting with environment and target environment objects in the repository. */
public interface EnvironmentRepository {

  Environment createEnvironment(Environment environment)
      throws StorageException, EnvironmentExistsException;

  Environment getEnvironment(String environmentId, String environmentVersion)
      throws StorageException;

  EnvironmentVersion createEnvironmentTargetVersion(EnvironmentVersion environmentVersion)
      throws StorageException, EnvironmentTargetRevisionExistsException;

  EnvironmentVersion getEnvironmentTargetVersion(String environmentId) throws StorageException;

  List<String> listClusters() throws StorageException;

  List<String> listEnvironmentIdsByCluster(String cluster) throws StorageException;
}