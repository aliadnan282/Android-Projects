package com.tarek360.komootsplashscreen;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.util.Log;
import android.view.animation.LinearInterpolator;

public class KomootDrawable extends Drawable {

    float viewBoxWidth = 720;
    float viewBoxHeight = 1280;

    private Path p = new Path();
    private Paint paint = new Paint();
    private float rotation = 180;
    private float translateY = 50;
    private int color;
    private int colorFrom;
    private int colorTo;
    private int colorSector;
    private int colorText;
    private float translateYSector = 100;
    private float factorScale;
    private float scale = 0.7f;


    public KomootDrawable(){
        color = 0xAA001100;
        colorFrom = 0x00001100;
        colorTo = 0xAA001100;

        colorSector = colorFrom;
        colorText = colorFrom;
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        super.onBoundsChange(bounds);

        float viewBoxRatio = viewBoxWidth / viewBoxHeight;
        float boundsRatio = bounds.width() / (float) bounds.height();
        if (boundsRatio > viewBoxRatio) {
            // canvas larger than viewbox
            factorScale = bounds.height() / viewBoxHeight;
        } else {
            // canvas higher (or equals) than viewbox
            factorScale = bounds.width() / viewBoxWidth;
        }
    }

    @Override
    public void draw(Canvas canvas) {


        Rect bounds = getBounds();
        if (viewBoxHeight <= 0 || viewBoxWidth <= 0 || bounds.width() <= 0 || bounds.height() <= 0) {
            return;
        }

        paint.setAntiAlias(true);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(color);

        canvas.save();

        int newViewBoxHeight = Math.round(factorScale * viewBoxHeight);
        int newViewBoxWidth = Math.round(factorScale * viewBoxWidth);
        int marginX = bounds.width() - newViewBoxWidth;
        int marginY = bounds.height() - newViewBoxHeight;
        canvas.translate(bounds.left, bounds.top);
        canvas.translate(Math.round(marginX / 2f), Math.round(marginY / 2f));
        canvas.clipRect(0, 0, newViewBoxWidth, newViewBoxHeight);
        canvas.scale(scale,scale,newViewBoxWidth/2, newViewBoxHeight/2);
        canvas.translate(factorScale * 0, factorScale * translateY);
        canvas.save();
        canvas.rotate(rotation, factorScale * 360.90f, factorScale * 587.172f);
        p.reset();
        p.moveTo(factorScale * 451.548004f, factorScale * 591.565979f);
        p.rCubicTo(factorScale * -0.265000f, factorScale * 14.635000f, factorScale * -5.699000f, factorScale * 32.138000f, factorScale * -16.718000f, factorScale * 47.938000f);
        p.rCubicTo(factorScale * -2.557000f, factorScale * 3.666000f, factorScale * -4.267000f, factorScale * 4.050000f, factorScale * -7.561000f, factorScale * 0.675000f);
        p.rCubicTo(factorScale * -13.386000f, factorScale * -13.714000f, factorScale * -26.982000f, factorScale * -27.224001f, factorScale * -40.633999f, factorScale * -40.674999f);
        p.rCubicTo(factorScale * -2.422000f, factorScale * -2.386000f, factorScale * -3.141000f, factorScale * -4.619000f, factorScale * -2.370000f, factorScale * -7.955000f);
        p.rCubicTo(factorScale * 2.107000f, factorScale * -9.125000f, factorScale * -1.916000f, factorScale * -18.587000f, factorScale * -9.770000f, factorScale * -23.907000f);
        p.rCubicTo(factorScale * -7.757000f, factorScale * -5.254000f, factorScale * -18.554001f, factorScale * -5.531000f, factorScale * -25.910999f, factorScale * -0.285000f);
        p.rCubicTo(factorScale * -8.103000f, factorScale * 5.779000f, factorScale * -12.213000f, factorScale * 13.614000f, factorScale * -10.253000f, factorScale * 23.704000f);
        p.rCubicTo(factorScale * 0.714000f, factorScale * 3.677000f, factorScale * 0.107000f, factorScale * 6.159000f, factorScale * -2.622000f, factorScale * 8.833000f);
        p.rCubicTo(factorScale * -13.569000f, factorScale * 13.296000f, factorScale * -27.027000f, factorScale * 26.711000f, factorScale * -40.297001f, factorScale * 40.304001f);
        p.rCubicTo(factorScale * -3.321000f, factorScale * 3.402000f, factorScale * -4.956000f, factorScale * 2.831000f, factorScale * -7.567000f, factorScale * -0.731000f);
        p.rCubicTo(factorScale * -38.595001f, factorScale * -52.651001f, factorScale * -7.172000f, factorScale * -130.197998f, factorScale * 57.292999f, factorScale * -141.188004f);
        p.cubicTo(factorScale * 401.089996f, factorScale * 488.739990f, factorScale * 451.535004f, factorScale * 530.807007f, factorScale * 451.548004f, factorScale * 591.565979f);
        p.close();
        canvas.drawPath(p, paint);
        canvas.restore();
        p.reset();
        p.moveTo(factorScale * 358.207001f, factorScale * 677.163025f);
        p.rCubicTo(factorScale * -23.101999f, factorScale * -1.247000f, factorScale * -41.830002f, factorScale * -9.203000f, factorScale * -57.939999f, factorScale * -23.662001f);
        p.rCubicTo(factorScale * -3.180000f, factorScale * -2.854000f, factorScale * -2.923000f, factorScale * -4.702000f, factorScale * -0.005000f, factorScale * -7.566000f);
        p.rCubicTo(factorScale * 13.321000f, factorScale * -13.073000f, factorScale * 26.448000f, factorScale * -26.344000f, factorScale * 39.646000f, factorScale * -39.542999f);
        p.rCubicTo(factorScale * 0.471000f, factorScale * -0.471000f, factorScale * 0.881000f, factorScale * -1.167000f, factorScale * 1.452000f, factorScale * -1.351000f);
        p.rCubicTo(factorScale * 10.385000f, factorScale * -3.355000f, factorScale * 12.590000f, factorScale * -13.303000f, factorScale * 17.228001f, factorScale * -21.284000f);
        p.rCubicTo(factorScale * 0.733000f, factorScale * -1.262000f, factorScale * 0.908000f, factorScale * -3.321000f, factorScale * 2.503000f, factorScale * -3.465000f);
        p.rCubicTo(factorScale * 2.106000f, factorScale * -0.190000f, factorScale * 2.170000f, factorScale * 2.162000f, factorScale * 2.925000f, factorScale * 3.515000f);
        p.rCubicTo(factorScale * 2.111000f, factorScale * 3.780000f, factorScale * 3.978000f, factorScale * 7.700000f, factorScale * 6.179000f, factorScale * 11.425000f);
        p.rCubicTo(factorScale * 2.253000f, factorScale * 3.814000f, factorScale * 4.193000f, factorScale * 8.008000f, factorScale * 9.458000f, factorScale * 8.787000f);
        p.rCubicTo(factorScale * 1.117000f, factorScale * 0.165000f, factorScale * 2.111000f, factorScale * 1.546000f, factorScale * 3.048000f, factorScale * 2.480000f);
        p.rCubicTo(factorScale * 13.212000f, factorScale * 13.185000f, factorScale * 26.333000f, factorScale * 26.462000f, factorScale * 39.653999f, factorScale * 39.534000f);
        p.rCubicTo(factorScale * 2.977000f, factorScale * 2.921000f, factorScale * 3.020000f, factorScale * 4.788000f, factorScale * -0.128000f, factorScale * 7.576000f);
        p.rCubicTo(factorScale * -15.896000f, factorScale * 14.079000f, factorScale * -34.183998f, factorScale * 22.278999f, factorScale * -55.528999f, factorScale * 23.287001f);
        p.cubicTo(factorScale * 363.381989f, factorScale * 677.052979f, factorScale * 360.071014f, factorScale * 677.650024f, factorScale * 358.207001f, factorScale * 677.163025f);
        p.close();
        p.moveTo(factorScale * 358.207001f, factorScale * 677.163025f);
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(colorSector);
        canvas.save();
        canvas.translate(factorScale * 0, factorScale * translateYSector);
        canvas.drawPath(p, paint);
        canvas.restore();
        p.reset();
        p.moveTo(factorScale * 156.259003f, factorScale * 782.539001f);
        p.rCubicTo(factorScale * -18.780001f, factorScale * -6.560000f, factorScale * -26.034000f, factorScale * -16.875000f, factorScale * -26.042000f, factorScale * -37.057999f);
        p.rCubicTo(factorScale * -0.006000f, factorScale * -15.482000f, factorScale * -0.017000f, factorScale * -30.964001f, factorScale * 0.008000f, factorScale * -46.445000f);
        p.rCubicTo(factorScale * 0.011000f, factorScale * -6.767000f, factorScale * 0.049000f, factorScale * -6.772000f, factorScale * 6.570000f, factorScale * -6.786000f);
        p.rCubicTo(factorScale * 4.162000f, factorScale * -0.008000f, factorScale * 8.336000f, factorScale * 0.202000f, factorScale * 12.482000f, factorScale * -0.051000f);
        p.rCubicTo(factorScale * 4.196000f, factorScale * -0.256000f, factorScale * 5.437000f, factorScale * 1.500000f, factorScale * 5.398000f, factorScale * 5.540000f);
        p.rCubicTo(factorScale * -0.161000f, factorScale * 16.646000f, factorScale * -0.048000f, factorScale * 33.293999f, factorScale * -0.079000f, factorScale * 49.941002f);
        p.rCubicTo(factorScale * -0.005000f, factorScale * 2.716000f, factorScale * 0.172000f, factorScale * 5.315000f, factorScale * 1.996000f, factorScale * 7.534000f);
        p.rCubicTo(factorScale * 2.703000f, factorScale * 3.288000f, factorScale * 6.123000f, factorScale * 4.147000f, factorScale * 9.785000f, factorScale * 2.195000f);
        p.rCubicTo(factorScale * 3.764000f, factorScale * -2.007000f, factorScale * 5.789000f, factorScale * -5.403000f, factorScale * 3.784000f, factorScale * -9.572000f);
        p.rCubicTo(factorScale * -1.529000f, factorScale * -3.178000f, factorScale * -0.892000f, factorScale * -5.118000f, factorScale * 1.540000f, factorScale * -7.322000f);
        p.rCubicTo(factorScale * 3.573000f, factorScale * -3.238000f, factorScale * 7.010000f, factorScale * -6.654000f, factorScale * 10.242000f, factorScale * -10.231000f);
        p.rCubicTo(factorScale * 2.685000f, factorScale * -2.972000f, factorScale * 4.484000f, factorScale * -2.385000f, factorScale * 6.643000f, factorScale * 0.572000f);
        p.rCubicTo(factorScale * 3.315000f, factorScale * 4.538000f, factorScale * 5.634000f, factorScale * 9.448000f, factorScale * 6.264000f, factorScale * 15.023000f);
        p.rCubicTo(factorScale * 0.393000f, factorScale * 3.481000f, factorScale * 1.829000f, factorScale * 5.400000f, factorScale * 5.299000f, factorScale * 6.804000f);
        p.rCubicTo(factorScale * 12.383000f, factorScale * 5.010000f, factorScale * 20.311001f, factorScale * 17.774000f, factorScale * 19.111000f, factorScale * 29.858000f);
        p.rCubicTo(factorScale * -8.000000f, factorScale * 0.000000f, factorScale * -16.000000f, factorScale * 0.000000f, factorScale * -24.000000f, factorScale * 0.000000f);
        p.rCubicTo(factorScale * 0.126000f, factorScale * -7.405000f, factorScale * -8.188000f, factorScale * -9.933000f, factorScale * -12.981000f, factorScale * -6.110000f);
        p.rCubicTo(factorScale * -3.853000f, factorScale * 3.073000f, factorScale * -8.394000f, factorScale * 4.680000f, factorScale * -13.019000f, factorScale * 6.110000f);
        p.cubicTo(factorScale * 164.925995f, factorScale * 782.539001f, factorScale * 160.591995f, factorScale * 782.539001f, factorScale * 156.259003f, factorScale * 782.539001f);
        p.close();
        p.moveTo(factorScale * 156.259003f, factorScale * 782.539001f);

        paint.setColor(colorText);

        canvas.drawPath(p, paint);

        p.reset();
        p.moveTo(factorScale * 243.259003f, factorScale * 782.539001f);
        p.rCubicTo(factorScale * -11.438000f, factorScale * -4.064000f, factorScale * -20.153000f, factorScale * -10.963000f, factorScale * -23.437000f, factorScale * -23.184999f);
        p.rCubicTo(factorScale * -4.617000f, factorScale * -17.184000f, factorScale * 4.965000f, factorScale * -34.610001f, factorScale * 21.608999f, factorScale * -39.596001f);
        p.rCubicTo(factorScale * 17.068001f, factorScale * -5.113000f, factorScale * 34.814999f, factorScale * 4.070000f, factorScale * 40.430000f, factorScale * 20.921000f);
        p.rCubicTo(factorScale * 5.560000f, factorScale * 16.686001f, factorScale * -3.397000f, factorScale * 34.638000f, factorScale * -20.313000f, factorScale * 40.709999f);

        p.rCubicTo(factorScale * -1.093000f, factorScale * 0.392000f, factorScale * -2.193000f, factorScale * 0.767000f, factorScale * -3.289000f, factorScale * 1.150000f);
        p.cubicTo(factorScale * 253.259003f, factorScale * 782.539001f, factorScale * 248.259003f, factorScale * 782.539001f, factorScale * 243.259003f, factorScale * 782.539001f);
        p.close();
        p.moveTo(factorScale * 243.259003f, factorScale * 782.539001f);
        p.moveTo(factorScale * 258.940002f, factorScale * 750.802979f);
        p.rCubicTo(factorScale * 0.040000f, factorScale * -4.289000f, factorScale * -3.502000f, factorScale * -7.908000f, factorScale * -7.781000f, factorScale * -7.948000f);
        p.rCubicTo(factorScale * -4.494000f, factorScale * -0.042000f, factorScale * -7.746000f, factorScale * 3.197000f, factorScale * -7.803000f, factorScale * 7.770000f);
        p.rCubicTo(factorScale * -0.060000f, factorScale * 4.904000f, factorScale * 2.749000f, factorScale * 7.797000f, factorScale * 7.562000f, factorScale * 7.786000f);
        p.cubicTo(factorScale * 255.533005f, factorScale * 758.401001f, factorScale * 258.898010f, factorScale * 755.208984f, factorScale * 258.940002f, factorScale * 750.802979f);
        p.close();
        p.moveTo(factorScale * 258.940002f, factorScale * 750.802979f);
        p.setFillType(Path.FillType.EVEN_ODD);


        canvas.drawPath(p, paint);

        p.reset();
        p.moveTo(factorScale * 287.980011f, factorScale * 752.260010f);
        p.rCubicTo(factorScale * 0.107000f, factorScale * -25.577999f, factorScale * 25.379000f, factorScale * -41.439999f, factorScale * 46.532001f, factorScale * -30.570999f);
        p.rCubicTo(factorScale * 4.800000f, factorScale * 2.466000f, factorScale * 7.939000f, factorScale * 2.253000f, factorScale * 12.524000f, factorScale * -0.153000f);
        p.rCubicTo(factorScale * 13.381000f, factorScale * -7.023000f, factorScale * 29.277000f, factorScale * -2.953000f, factorScale * 39.429001f, factorScale * 9.368000f);
        p.rCubicTo(factorScale * 8.851000f, factorScale * 10.741000f, factorScale * 9.162000f, factorScale * 26.982000f, factorScale * 0.739000f, factorScale * 38.581001f);
        p.rCubicTo(factorScale * -3.262000f, factorScale * 4.492000f, factorScale * -3.900000f, factorScale * 4.544000f, factorScale * -7.922000f, factorScale * 0.565000f);
        p.rCubicTo(factorScale * -2.605000f, factorScale * -2.577000f, factorScale * -5.084000f, factorScale * -5.293000f, factorScale * -7.803000f, factorScale * -7.741000f);
        p.rCubicTo(factorScale * -3.104000f, factorScale * -2.794000f, factorScale * -5.296000f, factorScale * -5.193000f, factorScale * -2.998000f, factorScale * -10.064000f);
        p.rCubicTo(factorScale * 1.746000f, factorScale * -3.702000f, factorScale * -0.888000f, factorScale * -7.078000f, factorScale * -4.557000f, factorScale * -8.856000f);
        p.rCubicTo(factorScale * -3.469000f, factorScale * -1.681000f, factorScale * -7.849000f, factorScale * -0.047000f, factorScale * -9.930000f, factorScale * 3.446000f);
        p.rCubicTo(factorScale * -1.243000f, factorScale * 2.086000f, factorScale * -1.344000f, factorScale * 4.399000f, factorScale * -1.427000f, factorScale * 6.753000f);
        p.rCubicTo(factorScale * -0.229000f, factorScale * 6.574000f, factorScale * -2.769000f, factorScale * 12.242000f, factorScale * -6.875000f, factorScale * 17.313000f);
        p.rCubicTo(factorScale * -1.859000f, factorScale * 2.296000f, factorScale * -3.463000f, factorScale * 2.652000f, factorScale * -5.657000f, factorScale * 0.323000f);
        p.rCubicTo(factorScale * -3.767000f, factorScale * -4.000000f, factorScale * -7.698000f, factorScale * -7.849000f, factorScale * -11.649000f, factorScale * -11.670000f);

        p.rCubicTo(factorScale * -1.665000f, factorScale * -1.610000f, factorScale * -1.894000f, factorScale * -3.049000f, factorScale * -0.978000f, factorScale * -5.284000f);
        p.rCubicTo(factorScale * 1.483000f, factorScale * -3.619000f, factorScale * 1.297000f, factorScale * -7.267000f, factorScale * -2.242000f, factorScale * -9.860000f);
        p.rCubicTo(factorScale * -3.006000f, factorScale * -2.202000f, factorScale * -6.267000f, factorScale * -2.344000f, factorScale * -9.295000f, factorScale * -0.165000f);
        p.rCubicTo(factorScale * -3.633000f, factorScale * 2.615000f, factorScale * -4.306000f, factorScale * 6.257000f, factorScale * -2.429000f, factorScale * 10.180000f);
        p.rCubicTo(factorScale * 1.098000f, factorScale * 2.296000f, factorScale * 0.279000f, factorScale * 3.697000f, factorScale * -1.266000f, factorScale * 5.241000f);
        p.rCubicTo(factorScale * -3.768000f, factorScale * 3.766000f, factorScale * -7.569000f, factorScale * 7.513000f, factorScale * -11.119000f, factorScale * 11.480000f);
        p.rCubicTo(factorScale * -2.357000f, factorScale * 2.633000f, factorScale * -4.051000f, factorScale * 2.134000f, factorScale * -6.017000f, factorScale * -0.319000f);
        p.cubicTo(factorScale * 290.260010f, factorScale * 764.859009f, factorScale * 288.162994f, factorScale * 757.999023f, factorScale * 287.980011f, factorScale * 752.260010f);
        p.close();
        p.moveTo(factorScale * 287.980011f, factorScale * 752.260010f);


        canvas.drawPath(p, paint);

        p.reset();
        p.moveTo(factorScale * 422.259003f, factorScale * 782.539001f);
        p.rCubicTo(factorScale * -16.466000f, factorScale * -5.843000f, factorScale * -25.368999f, factorScale * -17.186001f, factorScale * -25.186001f, factorScale * -32.091999f);
        p.rCubicTo(factorScale * 0.224000f, factorScale * -18.302000f, factorScale * 15.312000f, factorScale * -32.655998f, factorScale * 33.733002f, factorScale * -32.091000f);
        p.rCubicTo(factorScale * 17.936001f, factorScale * 0.550000f, factorScale * 31.855000f, factorScale * 15.963000f, factorScale * 30.889000f, factorScale * 34.151001f);
        p.rCubicTo(factorScale * -0.848000f, factorScale * 15.968000f, factorScale * -10.388000f, factorScale * 24.825001f, factorScale * -24.436001f, factorScale * 30.032000f);
        p.cubicTo(factorScale * 432.259003f, factorScale * 782.539001f, factorScale * 427.259003f, factorScale * 782.539001f, factorScale * 422.259003f, factorScale * 782.539001f);
        p.close();
        p.moveTo(factorScale * 422.259003f, factorScale * 782.539001f);
        p.moveTo(factorScale * 437.651001f, factorScale * 750.638977f);
        p.rCubicTo(factorScale * -0.017000f, factorScale * -4.043000f, factorScale * -4.008000f, factorScale * -7.854000f, factorScale * -8.140000f, factorScale * -7.773000f);
        p.rCubicTo(factorScale * -4.338000f, factorScale * 0.086000f, factorScale * -7.857000f, factorScale * 3.623000f, factorScale * -7.899000f, factorScale * 7.940000f);
        p.rCubicTo(factorScale * -0.042000f, factorScale * 4.362000f, factorScale * 3.407000f, factorScale * 7.632000f, factorScale * 8.016000f, factorScale * 7.600000f);
        p.cubicTo(factorScale * 434.101013f, factorScale * 758.375977f, factorScale * 437.667999f, factorScale * 754.922974f, factorScale * 437.651001f, factorScale * 750.638977f);
        p.close();
        p.moveTo(factorScale * 437.651001f, factorScale * 750.638977f);
        p.setFillType(Path.FillType.EVEN_ODD);


        canvas.drawPath(p, paint);

        p.reset();
        p.moveTo(factorScale * 490.259003f, factorScale * 782.539001f);

        p.rCubicTo(factorScale * -13.399000f, factorScale * -4.378000f, factorScale * -22.308001f, factorScale * -12.759000f, factorScale * -24.721001f, factorScale * -27.200001f);
        p.rCubicTo(factorScale * -2.885000f, factorScale * -17.257000f, factorScale * 10.064000f, factorScale * -34.409000f, factorScale * 27.976000f, factorScale * -36.825001f);
        p.rCubicTo(factorScale * 17.256001f, factorScale * -2.328000f, factorScale * 34.224998f, factorScale * 10.673000f, factorScale * 36.097000f, factorScale * 27.657000f);
        p.rCubicTo(factorScale * 1.911000f, factorScale * 17.344000f, factorScale * -6.314000f, factorScale * 29.628000f, factorScale * -24.351000f, factorScale * 36.368000f);
        p.cubicTo(factorScale * 500.259003f, factorScale * 782.539001f, factorScale * 495.259003f, factorScale * 782.539001f, factorScale * 490.259003f, factorScale * 782.539001f);
        p.close();
        p.moveTo(factorScale * 490.259003f, factorScale * 782.539001f);
        p.moveTo(factorScale * 497.480011f, factorScale * 758.408997f);
        p.rCubicTo(factorScale * 4.558000f, factorScale * 0.066000f, factorScale * 8.082000f, factorScale * -3.159000f, factorScale * 8.236000f, factorScale * -7.535000f);
        p.rCubicTo(factorScale * 0.139000f, factorScale * -3.953000f, factorScale * -3.832000f, factorScale * -7.972000f, factorScale * -7.919000f, factorScale * -8.015000f);
        p.rCubicTo(factorScale * -4.132000f, factorScale * -0.044000f, factorScale * -8.027000f, factorScale * 3.651000f, factorScale * -8.176000f, factorScale * 7.755000f);
        p.cubicTo(factorScale * 489.466003f, factorScale * 754.913025f, factorScale * 492.924988f, factorScale * 758.343018f, factorScale * 497.480011f, factorScale * 758.408997f);
        p.close();
        p.moveTo(factorScale * 497.480011f, factorScale * 758.408997f);
        p.setFillType(Path.FillType.EVEN_ODD);


        canvas.drawPath(p, paint);

        p.reset();
        p.moveTo(factorScale * 559.258972f, factorScale * 782.539001f);
        p.rCubicTo(factorScale * -11.497000f, factorScale * -4.043000f, factorScale * -19.934999f, factorScale * -11.146000f, factorScale * -23.431000f, factorScale * -23.268999f);
        p.rCubicTo(factorScale * -0.656000f, factorScale * -2.275000f, factorScale * -0.910000f, factorScale * -4.561000f, factorScale * -0.910000f, factorScale * -6.901000f);
        p.rCubicTo(factorScale * -0.002000f, factorScale * -18.155001f, factorScale * 0.111000f, factorScale * -36.311001f, factorScale * -0.090000f, factorScale * -54.464001f);
        p.rCubicTo(factorScale * -0.049000f, factorScale * -4.394000f, factorScale * 1.393000f, factorScale * -6.015000f, factorScale * 5.754000f, factorScale * -5.714000f);
        p.rCubicTo(factorScale * 4.144000f, factorScale * 0.286000f, factorScale * 8.341000f, factorScale * 0.300000f, factorScale * 12.483000f, factorScale * -0.002000f);
        p.rCubicTo(factorScale * 4.515000f, factorScale * -0.330000f, factorScale * 5.826000f, factorScale * 1.602000f, factorScale * 5.612000f, factorScale * 5.846000f);
        p.rCubicTo(factorScale * -0.276000f, factorScale * 5.482000f, factorScale * 0.039000f, factorScale * 10.992000f, factorScale * -0.104000f, factorScale * 16.485001f);
        p.rCubicTo(factorScale * -0.080000f, factorScale * 3.055000f, factorScale * 0.413000f, factorScale * 4.854000f, factorScale * 4.139000f, factorScale * 3.959000f);
        p.rCubicTo(factorScale * 3.736000f, factorScale * -0.898000f, factorScale * 5.109000f, factorScale * 1.002000f, factorScale * 4.932000f, factorScale * 4.654000f);
        p.rCubicTo(factorScale * -0.176000f, factorScale * 3.656000f, factorScale * -0.097000f, factorScale * 7.328000f, factorScale * -0.015000f, factorScale * 10.991000f);

        p.rCubicTo(factorScale * 0.097000f, factorScale * 4.350000f, factorScale * 0.473000f, factorScale * 8.246000f, factorScale * -5.107000f, factorScale * 10.374000f);
        p.rCubicTo(factorScale * -3.887000f, factorScale * 1.482000f, factorScale * -4.034000f, factorScale * 5.981000f, factorScale * -2.398000f, factorScale * 9.611000f);
        p.rCubicTo(factorScale * 1.741000f, factorScale * 3.863000f, factorScale * 5.435000f, factorScale * 5.469000f, factorScale * 9.168000f, factorScale * 3.877000f);
        p.rCubicTo(factorScale * 3.953000f, factorScale * -1.686000f, factorScale * 6.077000f, factorScale * -0.221000f, factorScale * 8.550000f, factorScale * 2.379000f);
        p.rCubicTo(factorScale * 3.668000f, factorScale * 3.856000f, factorScale * 7.599000f, factorScale * 7.463000f, factorScale * 11.419000f, factorScale * 11.175000f);
        p.rCubicTo(factorScale * 0.000000f, factorScale * 3.667000f, factorScale * 1.431000f, factorScale * 8.764000f, factorScale * -0.402000f, factorScale * 10.598000f);
        p.rCubicTo(factorScale * -1.833000f, factorScale * 1.833000f, factorScale * -6.931000f, factorScale * 0.402000f, factorScale * -10.598000f, factorScale * 0.402000f);
        p.cubicTo(factorScale * 571.926025f, factorScale * 782.539001f, factorScale * 565.591980f, factorScale * 782.539001f, factorScale * 559.258972f, factorScale * 782.539001f);
        p.close();
        p.moveTo(factorScale * 559.258972f, factorScale * 782.539001f);


        canvas.drawPath(p, paint);
        canvas.restore();
    }



    public void start() {

        int rotationTime = 6000;

        ValueAnimator rotationAnimator = ValueAnimator.ofFloat(180,3600);
        rotationAnimator.setDuration(rotationTime);
        rotationAnimator.setInterpolator(new LinearInterpolator());
        rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animatedValue = (float) animation.getAnimatedValue();
                Log.i("animation", "animatedValue " + animatedValue);
                rotation = animatedValue;
                invalidateSelf();

            }
        });

        int translateYSectorTime = 1000;
        ValueAnimator colorSectorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorSectorAnimation.setStartDelay(rotationTime);
        colorSectorAnimation.setDuration(translateYSectorTime);
        colorSectorAnimation.setInterpolator(new FastOutLinearInInterpolator());
        colorSectorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int animatedValue = (int) animation.getAnimatedValue();
                Log.i("animation", "colorSectorValue " + animatedValue);
                colorSector = animatedValue;
                invalidateSelf();

            }
        });

        ValueAnimator translateYSectorAnimator = ValueAnimator.ofFloat(100, 0);
        translateYSectorAnimator.setStartDelay(rotationTime);
        translateYSectorAnimator.setDuration(translateYSectorTime);
        translateYSectorAnimator.setInterpolator(new FastOutLinearInInterpolator());
        translateYSectorAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animatedValue = (float) animation.getAnimatedValue();
                Log.i("animation", "translateY animatedValue " + animatedValue);
                translateYSector = animatedValue;
                invalidateSelf();

            }
        });



        int translateYTime = 1000;

        ValueAnimator scaleAnimator = ValueAnimator.ofFloat(0.7f,1);
        scaleAnimator.setDuration(translateYTime);
        scaleAnimator.setStartDelay(rotationTime + translateYSectorTime);
        scaleAnimator.setInterpolator(new FastOutSlowInInterpolator());
        scaleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animatedValue = (float) animation.getAnimatedValue();
                Log.i("animation", "translateY animatedValue " + animatedValue);
                scale = animatedValue;
                invalidateSelf();

            }
        });

        ValueAnimator translateYAnimator = ValueAnimator.ofFloat(50,-50);
        translateYAnimator.setDuration(translateYTime);
        translateYAnimator.setStartDelay(rotationTime + translateYSectorTime);
        translateYAnimator.setInterpolator(new FastOutSlowInInterpolator());
        translateYAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                float animatedValue = (float) animation.getAnimatedValue();
                Log.i("animation", "translateY animatedValue " + animatedValue);
                translateY = animatedValue;
                invalidateSelf();

            }
        });

        ValueAnimator colorTextAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorTextAnimation.setStartDelay(rotationTime + translateYSectorTime + translateYTime);
        colorTextAnimation.setDuration(1000);
        colorTextAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

                int animatedValue = (int) animation.getAnimatedValue();
                Log.i("animation", "colorSectorValue " + animatedValue);
                colorText = animatedValue;
                invalidateSelf();

            }
        });





        AnimatorSet set  = new AnimatorSet();
        set.playTogether(rotationAnimator,colorSectorAnimation, translateYSectorAnimator, scaleAnimator, translateYAnimator, colorTextAnimation);
        set.start();
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return 0;
    }

    @Override
    public int getMinimumHeight() {
        return 18;
    }

    @Override
    public int getMinimumWidth() {
        return 10;
    }
}