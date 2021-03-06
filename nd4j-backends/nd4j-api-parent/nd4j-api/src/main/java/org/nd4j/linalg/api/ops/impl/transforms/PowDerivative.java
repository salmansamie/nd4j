/*-
 *
 *  * Copyright 2015 Skymind,Inc.
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 *
 */

package org.nd4j.linalg.api.ops.impl.transforms;

import org.nd4j.autodiff.samediff.SDVariable;
import org.nd4j.autodiff.samediff.SameDiff;
import org.nd4j.imports.NoOpNameFoundException;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.api.ops.BaseTransformOp;

import java.util.List;

/**
 * Pow derivative
 *
 * z = n * x ^ (n-1)
 *
 * @author raver119@gmail.com
 */
public class PowDerivative extends BaseTransformOp {
    private double pow;

    public PowDerivative(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2, double pow) {
        super(sameDiff, i_v1, i_v2);
        this.pow = pow;
    }

    public PowDerivative(SameDiff sameDiff, SDVariable i_v1, SDVariable i_v2, boolean inPlace, double pow) {
        super(sameDiff, i_v1, i_v2, inPlace);
        this.pow = pow;
    }

    public PowDerivative(SameDiff sameDiff, SDVariable i_v, boolean inPlace, double pow) {
        super(sameDiff, i_v, inPlace);
        this.pow = pow;
    }

    public PowDerivative(SameDiff sameDiff, SDVariable i_v, int[] shape, boolean inPlace, Object[] extraArgs, double pow) {
        super(sameDiff, i_v, shape, inPlace, extraArgs);
        this.pow = pow;
    }

    public PowDerivative(SameDiff sameDiff, SDVariable i_v, Object[] extraArgs, double pow) {
        super(sameDiff, i_v, extraArgs);
        this.pow = pow;
    }

    public PowDerivative() {}

    public PowDerivative(INDArray x, INDArray z, double pow) {
        super(x, z);
        this.pow = pow;
    }

    public PowDerivative(INDArray x, INDArray z, long n, double pow) {
        super(x, z, n);
        this.pow = pow;
    }

    public PowDerivative(INDArray x, INDArray y, INDArray z, long n, double pow) {
        super(x, y, z, n);
        this.pow = pow;
    }

    public PowDerivative(INDArray x, double pow) {
        super(x);
        this.pow = pow;
    }

    @Override
    public void init(INDArray x, INDArray y, INDArray z, long n) {
        super.init(x, y, z, n);
        this.extraArgs = new Object[] {pow};
    }

    @Override
    public int opNum() {
        return 92;
    }

    @Override
    public String opName() {
        return "_powderivative";
    }

    @Override
    public String onnxName() {
        throw new NoOpNameFoundException("No onnx op opName found for " +  opName());
    }

    @Override
    public String tensorflowName() {
        throw new NoOpNameFoundException("No tensorflow op opName found for " +  opName());
    }

       @Override
    public List<SDVariable> doDiff(List<SDVariable> f1) {
       throw new UnsupportedOperationException();
    }
}
